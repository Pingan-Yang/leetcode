package hot100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName leetcode84
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/12 19:39
 * @Version:1.0
 */
public class leetcode84 {
    // 暴力解法
    public int largestRectangleArea1(int[] heights) {
        // s=底*高
        // 固定高度，底向两边扩散
        int maxArea=0;
        int l=-1,r=-1;
        for (int i=0;i<heights.length;++i){
            if (i==0){
                l=0;
                int j=0;
                for (j=i;j<heights.length;++j){
                    if (heights[j]<heights[i]){
                        r=j-1;
                        break;
                    }
                }
                if (j==heights.length){
                    r=heights.length-1;
                }
                maxArea=Math.max(maxArea,(r-l+1)*heights[i]);
            }else if (i==heights.length-1){
                r=heights.length-1;
                int j=0;
                for (j=i;j>=0;j--){
                    if (heights[j]<heights[i]){
                        l=j+1;
                        break;
                    }
                }
                if (j<0){
                    l=0;
                }
                maxArea=Math.max(maxArea,(r-l+1)*heights[i]);
            }else{
                int j=0;
                for (j=i;j>=0;j--){
                    if (heights[j]<heights[i]){
                        l=j+1;
                        break;
                    }
                }
                if (j<0){
                    l=0;
                }
                int k=0;
                for (k=i;k<heights.length;++k){
                    if (heights[k]<heights[i]){
                        r=k-1;
                        break;
                    }
                }
                if (k>=heights.length){
                    r=heights.length-1;
                }
                maxArea=Math.max(maxArea,(r-l+1)*heights[i]);
            }
        }
        return maxArea;
    }
    // 单调栈
    public int largestRectangleArea(int[] heights){
        if (heights.length==1){
            return heights[0];
        }
        // Deque<Integer> stack=new ArrayDeque<>();
        Deque<Integer> stack=new ArrayDeque<>();
        // 为了保证连续性
        stack.push(-1);
        int maxArea=0;
        for (int i=0;i<heights.length;++i){
            // 当栈顶元素严格大于当前元素的高度时，出栈，此时就可以计算出以栈顶元素为高度的矩形的面积
            while (stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
                int curIndex=stack.pop();
                // 右边界-减去前一个索引-1（因为不包括前一个元素）
                // 这里计算的宽度是 当前的索引  减去出栈以后当前栈顶的的下标值在加1  就是弹出栈的元素的宽度
                // 这里计算的是以当前的索引的height所能围成的最大矩形面积
                // 栈顶中存在相高度的元素时，虽然计算不准确  但是不影响结果
                maxArea=Math.max(maxArea,heights[curIndex]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

       // System.out.println(stack);
        // 此时stack中时完全单调递增
        while (stack.peek()!=-1){

            int curIndex=stack.pop();
            maxArea=Math.max(maxArea,heights[curIndex]*(heights.length-stack.peek()-1));
        }

        return maxArea;


    }

    @Test
    public void test(){
        int[] heights={2,1,5,6,2,3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }
}
