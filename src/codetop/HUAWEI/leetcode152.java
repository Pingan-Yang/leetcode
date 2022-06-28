package codetop.HUAWEI;

/**
 * @ClassName leetcode152
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/27 16:57
 * @Version:1.0
 */

import org.junit.Test;

/**
 * leetcode 152:乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字）
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 */
public class leetcode152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        int ans=nums[0];
        max[0]=nums[0];
        min[0]=nums[0];
        for (int i=1;i<n;++i){
            max[i]=Math.max(Math.max(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            min[i]=Math.min(Math.min(min[i-1]*nums[i],max[i-1]*nums[i]),nums[i]);
            ans=Math.max(Math.max(max[i],min[i]),ans);
        }
        return ans;
    }

    @Test
    public void  test(){
        int[] nums={2,-1,1,1};
        int maxProduct = maxProduct(nums);
        System.out.println(maxProduct);
    }
}
