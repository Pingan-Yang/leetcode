package codetop.HUAWEI;

/**
 * @ClassName offer48
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/14 19:21
 * @Version:1.0
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 */
public class offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        int maxlength = 1;
        int l = 0;
        int r = -1;
        for (; l < n; ++l) {

            if (l != 0) {
                set.remove(array[l-1]);
            }

            while (r + 1 < n && !set.contains(array[r + 1])) {
                set.add(array[r + 1]);
                r++;
            }

            maxlength = Math.max(maxlength, r - l + 1);
        }

        return maxlength;

    }

    @Test
    public void test(){
        String s="abcabcbb";
        int ans = lengthOfLongestSubstring(s);
        System.out.println("ans:"+ans);
    }
}
