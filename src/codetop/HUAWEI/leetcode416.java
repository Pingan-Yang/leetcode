package codetop.HUAWEI;

/**
 * @ClassName leetcode416
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 14:56
 * @Version:1.0
 */

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class leetcode416 {
    /**
     * 可以转换为0-1背包问题
     * 从数组中找出一些数的和等于 target
     * dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数（可以是 0 个），
     * 是否存在一种选取方案使得被选取的正整数的和等于 j。初始时，dp 中的全部元素都是 false。
     */
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        //dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j。
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = false;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; ++i) {
            int num = nums[i];
            for (int j = 0; j <= target; ++j) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


//        for (boolean[] f:dp){
//            System.out.println(Arrays.toString(f));
//        }
        return dp[n - 1][target];
    }

    //优化成一维
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];

    }

    @Test
    public void test() {
        int[] nums = {1,5,11,5};
        boolean ans = canPartition1(nums);
        System.out.println(ans);
    }
}
