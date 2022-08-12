package codetop.HUAWEI;

/**
 * @ClassName leetcode438
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/15 17:08
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class leetcode438 {

    /**
     *执行用时：1850 ms, 在所有 Java 提交中击败了4.99%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了35.70%的用户
     */
    public List<Integer> findAnagrams1(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return new ArrayList<>();
        }

        int n = s.length();
        int m = p.length();
        char[] src = p.toCharArray();
        Arrays.sort(src);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n - m; ++i) {
            char[] sub = s.substring(i, i+m).toCharArray();
            Arrays.sort(sub);
            if (Arrays.equals(src, sub)) {
                res.add(i);
            }

        }
        return res;
    }

    @Test
    public void test(){
        String s="cbaebabacd";
        String p="abc";
        List<Integer> list = findAnagrams1(s, p);
        System.out.println(list);
    }

//    public List<Integer> findAnagrams(String s, String p){
//
//    }
}
