package dp.easy;

import org.junit.Test;

import java.util.Map;

/**
 * @ClassName leetcode53
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/8 20:03
 * @Version:1.0
 */
public class leetcode53 {
    /**
     * 给你一个整数数组 nums
     * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * f(i):以 nums[i] 结尾的连续子数组的最大和
     * f[i]=Math.max(nums[i],f[i-1]+nums[i])
     *
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] f=new int[nums.length];
        f[0]=nums[0];
        int ans=f[0];
        for (int i=1;i<nums.length;++i){
            f[i]=Math.max(nums[i],f[i-1]+nums[i]);
            ans=Math.max(ans,f[i]);
        }
        return ans;
    }

    /**
     * 滚动数组
     */
    public int maxSubArray2(int[] nums){
        if (nums.length==1){
            return nums[0];
        }
        int pre=0;
        int ans=nums[0];
        for (int i=0;i<nums.length;++i){
            pre=Math.max(pre+nums[i],nums[i]);
            ans=Math.max(pre,ans);
        }
        return ans;


    }
    @Test
    public void test(){
        int[] nums={5,4,-1,7,8};
        int maxSubArray = maxSubArray2(nums);
        System.out.println(maxSubArray);
    }
}
