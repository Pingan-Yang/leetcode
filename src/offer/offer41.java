package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName offer41
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 10:05
 * @Version:1.0
 */
public class offer41 {

    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
     * 那么中位数就是所有数值排序之后位于中间的数值。如
     * 果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *

     */
}

class MedianFinder1 {
//执行用时：
//1803 ms
//, 在所有 Java 提交中击败了
//5.03%
//的用户
    List<Integer>list;
    /** initialize your data structure here. */
    public MedianFinder1() {
        list=new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int size=list.size();
        if (size%2==0){
            return (list.get(size/2)+list.get(size/2-1))/2.0;
        }else{
            return list.get(size/2)/1.0;
        }

    }
}

class MedianFinder {

    //维护两个堆
    PriorityQueue<Integer> minHeap;//小顶堆 用于存储较大值的一半
    PriorityQueue<Integer> maxHeap;//大顶堆 用于存储较小值的一半


    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<Integer>((num1,num2)->num2-num1);

    }

    public void addNum(int num) {
        if (minHeap.size()==maxHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0:minHeap.peek()/1.0;
    }
}
