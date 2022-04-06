package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName leetcode5
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/29 11:24
 * @Version:1.0
 */
public class leetcode5 {
    // 暴力法---会超出时间限制
    public String longestPalindrome_1(String s) {
        // 暴力法
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        ArrayList<String> list = new ArrayList<>();
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            str1.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); ++j) {
                str1.append(s.charAt(j));
                String str = str1.toString();
                if (str.equals(str1.reverse().toString())) {//这里一定要加.toString()  不然始终为false
                    list.add(str);
                    str1.reverse();
                    continue;
                }
                str1.reverse();
            }
            int end = str1.length();
            str1.delete(0, end);
        }
        if (list.size() == 0) {
            return new String(s.charAt(0) + "");
        }
        ArrayList<Integer> len = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            len.add(list.get(i).length());
        }
        int maxlen = Collections.max(len);
        for (int j = 0; j < list.size(); ++j) {
            if (list.get(j).length() == maxlen) {
                return list.get(j);
            }
        }
        return null;
    }

    // dp
    public String longestPalindrome(String s) {
        /**
         * dp[i][j]:表示从i位置到j位置是否是回文子串
         * 转移方程：
         *      ①：s[i]≠s[j] ===>dp[i][j]=false;
         *      ②：s[i]=s[j]
         *             j-i<=2===>dp[i][j]=true;
         *             j-i>1===>dp[i][j]==dp[i+1][j-1]
         *      注意：i是从大到小的，j是从小到大的
         */

        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        int start = 0;// 记录最长回文子串 开始的位置
        int max = 1;
        // 初始化dp数组
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < n - 1 && i < j; ++i) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]&& j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+max);

    }

    @Test
    public void test() {
        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
