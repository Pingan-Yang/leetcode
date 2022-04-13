package offer;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName offer09
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 21:11
 * @Version:1.0
 */
public class offer09 {
//    剑指 Offer 09. 用两个栈实现队列

}
class CQueue {
    Deque<Integer>inStack;
    Deque<Integer>outStack;
    public CQueue() {
        inStack= new ArrayDeque<>();
        outStack=new ArrayDeque<>();

    }
    public void appendTail(int value) {
        inStack.push(value);

    }
    public int deleteHead() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()){
            return -1;
        }else{
            return outStack.pop();
        }

    }

}
