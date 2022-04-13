package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName offer30
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 21:28
 * @Version:1.0
 */
public class offer30 {
    //包含min函数的栈
    //定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

}
class MinStack {

    Deque<Integer> stack;
    Deque<Integer>minStack;
    /** initialize your data structure here. */
    public MinStack() {

        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        Integer value=stack.pop();
        if (value.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
