package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName offer59II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 21:29
 * @Version:1.0
 */
public class offer59II {
    //队列的最大值
}

//需要维护一个单调递减队列
class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> maxDeque;

    public MaxQueue() {
        deque=new LinkedList<>();
        maxDeque=new LinkedList<>();
    }

    public int max_value() {
        if (!maxDeque.isEmpty()){
            return maxDeque.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        //需要维护单调队列的递减性
        while (!maxDeque.isEmpty()&&maxDeque.peekLast()<value){
            maxDeque.pollLast();
        }
        maxDeque.addLast(value);
        deque.addLast(value);

    }

    public int pop_front() {
        if (deque.isEmpty()){
            return -1;
        }
        int ans=deque.pollFirst();
        if (ans==maxDeque.peekFirst()){
            maxDeque.pollFirst();
        }
        return ans;
    }
}
