package offer;

import org.junit.Test;

/**
 * @ClassName offer42
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/22 14:57
 * @Version:1.0
 */
public class offer42 {
    public int maxSubArray(int[] nums) {
        // dp[i]表示0-i索引的最大连续子数组和
        if (nums.length<=1){
            return nums[0];
        }
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;++i){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}
