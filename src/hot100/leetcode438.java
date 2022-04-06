package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode438
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/22 19:38
 * @Version:1.0
 */
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new ArrayList<Integer>();
        }
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP) {
            return new ArrayList<Integer>();
        }
        // 一种经典思路是初始化p的字符数组然后维护数组每个元素不小于0。
        // 开始向右滑动窗口，减去并相应字符，如果频率小于0就收缩左侧边界直到频率不再小于0。
        // 窗口长度与p长度一致时达成条件。

        int[] pCount = new int[26];
        for (int i = 0; i < lenP; ++i) {
            ++pCount[p.charAt(i) - 'a'];

        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int l = 0, r = 0; r < lenS; ++r) {
            --pCount[s.charAt(r) - 'a'];
            while (pCount[s.charAt(r) - 'a'] < 0) {
                ++pCount[s.charAt(l) - 'a'];
                ++l;
            }
            if (r - l + 1 == lenP) {
                res.add(l);
            }
        }
        return res;
    }

    @Test
    public void test(){
        String s="cbaebabacd";
        String p="abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
