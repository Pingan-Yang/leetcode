package hot100;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode647
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/26 21:11
 * @Version:1.0
 */
public class leetcode647 {
    boolean[][] dp;
    int count = 0;
    public int countSubstrings(String s) {
        // dp[i][j]：表示区间范围[i,j]的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        // 状态转移方程
        // s[i]≠s[j]-->dp[i][j]=false
        // s[i]==s[j]-->
        //          ①：i==j-->dp[i][j]=true
        //          ②：j-i==1-->dp[i][j]=true
        //          ③：j-i>1 说明区间内的字符数已经大于三个所以要判断此区间是不是回文字符串将区间缩小即可
        //              dp[i][j]=dp[i+1][j-1]
        // 由于dp[i][j]是由dp[i+1][j-1]推到的  所以 要注意遍历顺序i 大->小  j 小->大（j应该从i开始正序遍历）
        int n = s.length();
        dp =new boolean[n ][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i)==s.charAt(j)) {
                    if (j - i <= 1) {// 情况一和情况三
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i+1][j-1]){
                        count++;
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        String s="abccbatfgdfrssrpkhj";
        int countSubstrings = countSubstrings(s);
        System.out.println(countSubstrings);
        for (int i=0;i<dp.length;++i){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
