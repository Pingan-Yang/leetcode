package codetop.HUAWEI;

/**
 * @ClassName leetcode300
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 22:26
 * @Version:1.0
 */

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * leetcode300:给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // dp[i]:表示考虑以第i个元素结尾最长上升子序列的长度，nums[i]必须被选取
        int[] dp=new int[n];
        int ans=1;
        dp[0]=1;
        for (int i=1;i<n;++i){
            dp[i]=1;
            for (int j=0;j<i;++j){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums={10,9,2,5,3,7,101,18};
        int length = lengthOfLIS(nums);
        System.out.println(length);
    }
}
