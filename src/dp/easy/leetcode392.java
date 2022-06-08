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
        return i==sArrays.length?true:false;
    }

    @Test
    public void test(){
        String s="axc";
        String t="ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
