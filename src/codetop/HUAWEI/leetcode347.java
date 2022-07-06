package codetop.HUAWEI;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName leetcode347
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/6 21:28
 * @Version:1.0
 */
public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 建立一个小根堆
        // 如果堆的元素个数小于 k，就可以直接插入堆中。
        // 如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。
        // 如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；
        // 否则，就弹出堆顶，并将当前值插入堆中。
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        Queue<int[]>queue=new PriorityQueue<>(k,(o1,o2)->o1[1]-o2[1]);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num=entry.getKey();
            int count=entry.getValue();
            if (queue.size()==k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret=new int[k];
        for (int i=0;i<k;++i){
            ret[i]=queue.poll()[0];
        }
        return ret;

    }

    @Test
    public void test(){
        //nums = [1,1,1,2,2,3], k = 2
        int[] nums={1,1,1,2,2,3};
        int k=2;
        int[] kFrequent = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(kFrequent));
    }
}
