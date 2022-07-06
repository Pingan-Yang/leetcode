package codetop.HUAWEI;

/**
 * @ClassName leetcode187
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/4 20:24
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 *
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *  例如，"ACGAATTCCG" 是一个 DNA序列 。
 *在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 */
public class leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int n=s.length();
        for (int i=0;i<=n-10;++i) {
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub)) {
                map.put(sub, 1);
            } else {
                map.put(sub, map.get(sub) + 1);
            }

            if (map.get(sub)==2){
                list.add(sub);
            }
        }
        return list;
    }

    @Test
    public void test(){
        String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> dnaSequences = findRepeatedDnaSequences(s);
        System.out.println(dnaSequences);
    }
}
