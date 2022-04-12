package hot100;

import org.junit.Test;


import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @ClassName leetcode85
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/12 21:33
 * @Version:1.0
 */
public class leetcode85 {
    //利用84题的单调栈
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        // 这里的二维数组可以看成多个一维数组
        // 随着行数的增加，数组的列高发生变化
        int[] height=new int[n];
        int maxArea=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;++j){
                //这里就构造出了高度的一维数组，问题就换成了84题的问题
                if (matrix[i][j]=='1'){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }
            int curMaxArea = maxArea(height);
            maxArea=Math.max(curMaxArea,maxArea);
        }
        return maxArea;
    }
    private int maxArea(int[] heights){
        if (heights.length==1){
            return heights[0];
        }
        int maxArea=0;
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(-1);
        int n=heights.length;
        for (int i=0;i<n;++i){
            while (stack.peek()!=-1&&heights[i]<heights[stack.peek()]){
                int index=stack.pop();
                maxArea=Math.max(maxArea,heights[index]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            int index=stack.pop();
            maxArea=Math.max(maxArea,heights[index]*(n-stack.peek()-1));
        }
        return maxArea;
    }

    @Test
    public void test(){
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println("maximalRectangle:"+maximalRectangle);
    }
}
