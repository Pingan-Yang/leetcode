package codetop.HUAWEI;

/**
 * @ClassName leetcode516
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/27 16:33
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class leetcode516 {
    /**
     * dp[i][j]:从i位置开始到j位置最长回文子串的长度
     * s[i]!=s[j]
     *      s[i]s 和 s[j]不可能同时作为同一个回文子序列的首尾
     *      ====>dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
     * s[i]==[j]
     *      则首先得到 s的下标范围 [i+1,j−1] 内的最长回文子序列，
     *      然后在该子序列的首尾分别添加s[i]和s[j]，即可得到 s 的下标范围 [i,j] 内的最长回文子序列
     *      =====>dp[i][j]=dp[i+1][j-1]+2;
     */
    public int longestPalindromeSubseq(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        int n=s.length();
        char[] charArray = s.toCharArray();
        int[][] dp=new int[n][n];
        for (int i=0;i<n;++i){
            dp[i][i]=1;
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i+1;j<n;++j){
                if (charArray[i]==charArray[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    @Test
    public void test(){
        String s="bbbab";
        int ans = longestPalindromeSubseq(s);
        System.out.println(ans);
    }
}
