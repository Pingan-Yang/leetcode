package hot100;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName leetcode739
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/26 21:46
 * @Version:1.0
 */
public class leetcode739 {
    public int[] dailyTemperatures(int[] temperatures){
        // 用单调栈试试
        Deque<Integer> stack = new LinkedList<Integer>();
        int n=temperatures.length;
        int[] result=new int[n];
        for (int i=0;i<n;++i){
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    @Test
    public void test(){
        int[] temperatures ={73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }
}
