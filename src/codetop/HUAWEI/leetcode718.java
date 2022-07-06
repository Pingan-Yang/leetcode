package codetop.HUAWEI;

/**
 * @ClassName leetcode718
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/6 20:07
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode718: 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class leetcode718 {

    /**
     * 注意：子序列默认不连续，子数组默认连续
     * dp[i][j]:代表数组nums1前i个字符 nums2前j个字符中公共的长度最长的子数组长度
     *
     * ①：nums[i]!=nums[j]   dp[i][j]=0;
     * ②：nums[i]==nums[j]   dp[i][j]=dp[i-1][j-1]+1;
     *
     */
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return 0;
        }
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        int ans=0;
        for (int i=1;i<=m;++i){
            for (int j=1;j<=n;++j){
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }

        for (int[] nums:dp){
            System.out.println(Arrays.toString(nums));
        }

        return ans;
    }
    @Test
    public void test(){
//      nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        int[] nums1={0,1,1,1,1};
        int[] nums2={1,0,1,0,1};
        int length = findLength(nums1, nums2);
        System.out.println(length);
    }
}
