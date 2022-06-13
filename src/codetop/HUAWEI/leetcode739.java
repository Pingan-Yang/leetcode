package codetop.HUAWEI;

/**
 * @ClassName leetcode739
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 20:05
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 */
public class leetcode739 {
    //暴力解
    public int[] dailyTemperatures1(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        for (int i=0;i<n-1;++i){
            for (int j=i+1;j<n;++j){
                if (temperatures[j]>temperatures[i]){
                    ans[i]=j-i;
                    break;
                }else if (j==n-1){
                    ans[i]=0;
                }
            }
        }
        ans[n-1]=0;
        return ans;
    }

    /**
     * 利用单调栈：
     *      将比栈顶元素严格小的元素的下标 插入到栈中
     *      当遇到比栈顶大的元素，依次比较栈顶元素与cur的大小。cur大则出栈  记录结果
     */
    public int[] dailyTemperatures(int[] temperatures){

        int n=temperatures.length;
        int[] ans=new int[n];
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i=0;i<n;++i){
            int cur=temperatures[i];
            while (!stack.isEmpty()&&cur>temperatures[stack.peek()]){
                int prev=stack.pop();
                ans[prev]=i-prev;
            }
            stack.push(i);
        }
        return ans;

    }

    @Test
    public void test(){
        int [] t={73,74,75,71,69,72,76,73};
        int[] temperatures = dailyTemperatures(t);
        System.out.println(Arrays.toString(temperatures));
    }
}
