package codetop.HUAWEI;

/**
 * @ClassName leetcode451
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/4 20:07
 * @Version:1.0
 */

import org.junit.Test;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
。
 */
public class leetcode451 {
    public String frequencySort(String s) {
        if (s==null||s.length()<2){
            return s;
        }
        HashMap<Character,Integer> map=new HashMap<>();

        char[] array = s.toCharArray();
        for (char c:array){
            if (!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }

        List<Character>list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)-> map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        int n=list.size();
        for (int i=0;i<n;++i){
            char c=list.get(i);
            for (int j=0;j<map.get(c);++j){
                sb.append(c);
            }
        }
        return sb.toString();

    }

    @Test
    public void test(){
        String s="tree";
        String s1 = frequencySort(s);
        System.out.println(s1);
    }
}
