package codetop.HUAWEI;

/**
 * @ClassName leetcode5
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 15:05
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 5.最长回文子串：给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class leetcode5 {

    /**
     * 动态规划:
     * dp[i][j]:代表从i位置到j位置是否是回文子串
     * ①：s[i]≠s[j] ===>dp[i][j]=false;
     * ②：s[i]=s[j]
     * j-i<=2===>dp[i][j]=true;
     * j-i>1===>dp[i][j]==dp[i+1][j-1]
     * 注意：i是从大到小的，j是从小到大的
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len==1){
            return s;
        }
        char[] array = s.toCharArray();

        boolean[][] dp = new boolean[len][len];
        //初始化dp数组
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }

        int maxlen=1;
        int satrt=0;

        //位置j
        for (int j = 1; j < len; ++j) {
            //位置i
            for (int i = 0; i < len - 1 && i < j; ++i) {
                if (array[i] == array[j]) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if (dp[i][j]&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    satrt=i;
                }
            }
        }
        return  s.substring(satrt,satrt+maxlen);
    }


    @Test
    public void test(){
        String s="babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
