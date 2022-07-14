package codetop.HUAWEI;

/**
 * @ClassName leetcode692
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/14 21:17
 * @Version:1.0
 */

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 *
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 */

public class leetcode692 {
    /**
     * 我们利用哈希表记录每一个字符串出现的频率，然后将哈希表中所有字符串进行排序，
     * 排序时，如果两个字符串出现频率相同，那么我们让两字符串中字典序较小的排在前面，
     * 否则我们让出现频率较高的排在前面。最后我们只需要保留序列中的前 k 个字符串即可。
     *
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map=new HashMap<>();

        for (String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<String> res=new ArrayList<>();

        for (Map.Entry<String,Integer>entry :map.entrySet()){
            res.add(entry.getKey());
        }

        Collections.sort(res,(s1,s2)->{
           return   map.get(s1)==map.get(s2)?s1.compareTo(s2):map.get(s2)-map.get(s1);
        });

        return res.subList(0,k);
    }

    /**
     *小根堆+哈希表
     */

    public List<String> topKFrequent2(String[] words, int k) {
        // 1.先用哈希表统计单词出现的频率
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 2.构建小根堆 这里需要自己构建比较规则 此处为 lambda 写法 Java 的优先队列默认实现就是小根堆
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (count.get(s1).equals(count.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return count.get(s1) - count.get(s2);
            }
        });
        // 3.依次向堆加入元素。
        for (String s : count.keySet()) {
            minHeap.offer(s);
            // 当堆中元素个数大于 k 个的时候，需要弹出堆顶最小的元素。
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 4.依次弹出堆中的 K 个元素，放入结果集合中。
        List<String> res = new ArrayList<String>(k);
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        // 5.注意最后需要反转元素的顺序。
        Collections.reverse(res);
        return res;
    }
}
