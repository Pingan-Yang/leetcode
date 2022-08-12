package codetop.HUAWEI;

/**
 * @ClassName leetcode49
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/14 21:38
 * @Version:1.0
 */

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 */
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0){
            return new ArrayList<List<String>>();
        }

        Map<String,List<String>> map =new HashMap<String,List<String>>();
        for (String s:strs){
            char[] chars=s.toCharArray();
            //排序后的字符顺序一致可以作为key
            Arrays.sort(chars);
            String key=new String(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            //将key一致的字符串加入map
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());

    }
}
