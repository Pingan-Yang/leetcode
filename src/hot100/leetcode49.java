package hot100;

import java.util.*;

/**
 * @ClassName leetcode49
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/10 20:27
 * @Version:1.0
 */
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //字母相同，但排列不同的字符串，排序后都一定是相同的。
        // 因为每种字母的个数都是相同的，那么排序后的字符串就一定是相同的
        if (strs==null||strs.length==0){
            return new ArrayList<List<String>>();
        }
        // key：字母异位词的标志  value：所有的字母异位词
        Map<String,List<String>> map =new HashMap<String,List<String>>();
        for (String str:strs){
            // 对于相同的字母异位词首先转成数组
            char[] chars=str.toCharArray();
            // 排序---排完序所有的字母异位词都相等
            Arrays.sort(chars);
            String key=new String(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
