package offer;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;

/**
 * @ClassName offer31
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 10:24
 * @Version:1.0
 */
public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //借用一个辅助栈，模拟压栈、出栈
        //入栈操作： 按照压栈序列的顺序执行。
        //出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
        LinkedList<Integer> stack=new LinkedList<>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
