package codetop.HUAWEI;

/**
 * @ClassName leetcode53
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 22:06
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 最大子数组和：
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int prev=0;
        int ans=nums[0];
        for (int i=0;i<n;++i){
            prev=Math.max(nums[i],prev+nums[i]);
            ans=Math.max(ans,prev);
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}
