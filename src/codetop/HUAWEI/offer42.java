package codetop.HUAWEI;

/**
 * @ClassName offer42
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 22:36
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 */
public class offer42 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int ans=nums[0];
        dp[0]=nums[0];
        for (int i=1;i<n;++i){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            ans=Math.max(ans,dp[i]);
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
