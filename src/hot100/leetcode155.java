package hot100;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName leetcode155
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 21:27
 * @Version:1.0
 */
public class leetcode155 {
}
class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minValueStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new LinkedList<Integer>();
        minValueStack=new LinkedList<Integer>();

    }

    public void push(int val) {
        stack.push(val);
        //因为每次push的操作时，总会加入最小值，所以pop的时候要一起pop
        if (minValueStack.isEmpty()){
            minValueStack.push(val);
        }else{
            minValueStack.push(Math.min(val,minValueStack.peek()));
        }
    }

    public void pop() {
       stack.pop();
        minValueStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValueStack.peek();
    }
}
