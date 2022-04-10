package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode53
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/9 20:46
 * @Version:1.0
 */
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        // dp[i]==>dp[i]表示以第i个元素结尾时的最大连续和
        // dp[i]=  max{dp[i-1]+num[i],nums[i]}
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

        }
        System.out.println(Arrays.toString(dp));
        // 要排序  因为不一定是以nums[n-1]结尾的连续最大子数组之和最大
        Arrays.sort(dp);
        return dp[n - 1];
    }


    @Test
    public void test() {
        //[-2, 1, -2, 4, 3, 5, 6, 1, 5]
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);//23
    }
}
