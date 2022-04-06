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
        // dp的状态转移方程 fmax(i)=Max(f(i-1)+ai,ai)   f(i)表示以第i个元素结尾时的最大连续和
        if (nums==null||nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for (int i=1;i<n;++i){
            int curMaxValue=Math.max(dp[i-1]+nums[i],nums[i]);
            dp[i]=curMaxValue;
        }
        Arrays.sort(dp);
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    @Test
    public void test(){
        //[5, 9, 8, 15, 23]
        int[] nums={-5,4,-1,7,8};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);//23
    }
}
