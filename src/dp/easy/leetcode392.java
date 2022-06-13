package dp.easy;

/**
 * @ClassName leetcode392
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/8 21:24
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）

 */
public class leetcode392 {
    /**
     *贪心：
     *  在s中的字符每次匹配t中的字符 都优先匹配前面的（假设s中字符c 在t中位置 又x1,x2  x1<x2
     *  ,则匹配 x1是最优解,因为x2后面的字符x1也能取到，并且通过x1与x2之间的可选字符，更有希望匹配成功）
     *
     *  利用双指针 从字符串开头开始匹配 指向s的指针能移动到末尾则证明可以匹配成功
     */
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int i=0;
        int j=0;
        char[] sArrays = s.toCharArray();
        char[] tArrays = t.toCharArray();
        while (i<sArrays.length&&j<tArrays.length){
            if (sArrays[i]==tArrays[j]){
                i++;
            }
            j++;
        }
        return i==sArrays.length;
    }

    /**
     * 动态规划：
     *     令 f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
     *     在进行状态转移时，如果 t 中位置 i 的字符就是 j，那么 f[i][j]=i,否则 j出现在位置 i+1开始往后,
     *     即 f[i][j]=f[i+1][j]，因此我们要倒过来进行动态规划，从后往前枚举 i
     *                 i   t[i]=j
     *     f[i][j]==
     *                f[i+1][j] t[i]≠j
     *
     *  该解法中对 t 的处理与 s 无关，且预处理完成后，可以利用预处理数组的信息，线性地算出任意一个字符串 s 是否为 t的子串
     */
    public boolean isSubsequence2(String s, String t){
        int n = s.length(), m = t.length();

        //f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
    @Test
    public void test(){
        String s="ac";
        String t="ahbgdc";
        boolean subsequence = isSubsequence2(s, t);
        System.out.println(subsequence);
    }
}
