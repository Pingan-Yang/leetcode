package codetop.HUAWEI;

/**
 * @ClassName leetcode1143
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/29 20:22
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 *"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class leetcode1143 {

    /**
     *动态规划：
     *  最长公共子序列问题是典型的二维动态规划问题。
     *   dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。
     *   text1[0:i] 表示 text1的长度为 i 的前缀
     *   text2[0:j] 表示 text1的长度为 j 的前缀
     *边界条件：
     *  当 i=0 时，text1[0:i] 为空，空字符串和任何字符串的最长公共子序列的长度都是 0，因此对任意 0≤j≤n，有 dp[0][j]=0；
     *  当 j=0 时，text2[0:j] 为空，同理可得，对任意0≤i≤m，有 dp[i][0]=0;
     *
     *  当 i>0且 j>0 时，考虑 dp[i][j] 的计算：
     *      当 text1[i-1]=text2[j-1]，将这两个相同的字符称为公共字符，考虑text1[0:i-1]和text2[0:j-1]的最长公共子序列
     *      再增加一个字符（即公共字符）即可得到text1[0：i]和text2[0：j]，
     *      ===>dp[i][j]=dp[i-1][j-1]+1;
     *
     *      text1[i-1]≠text2[j-1],考虑下面两项：
     *         text1[0：i-1]和text2[0：j]的最长公共子序列
     *         text1[0：i]和text2[0：j-1]的最长公共子序列
     *      ==>dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
     *

     */
    public int longestCommonSubsequence(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();
        //dp[i][j]:代表text1[0:i]和text2[0:j]的最长公共子序列的长度
        int[][]dp=new int[m+1][n+1];
        for (int i=1;i<=m;++i){
            char c1=text1.charAt(i-1);
            for (int j=1;j<=n;++j){
                char c2=text2.charAt(j-1);
                if (c1==c2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];


    }
    @Test
    public void test(){
        String text1="abcde";
        String text2="ace";
        int longestCommonSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println(longestCommonSubsequence);
    }

}
