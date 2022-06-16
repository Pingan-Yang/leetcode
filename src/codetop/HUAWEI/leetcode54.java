package codetop.HUAWEI;

/**
 * @ClassName leetcode54
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 19:46
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵：
 *      给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class leetcode54 {
    /**
     *按层模拟
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if (matrix==null||matrix.length==0|matrix[0].length==0){
            return res;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //定义四个边界
        int top=0;
        int botten=m-1;
        int left=0;
        int right=n-1;

        while (top<=botten&&left<=right){
            for (int i=left;i<=right;++i){
                res.add(matrix[top][i]);
            }
            for (int i=top+1;i<=botten;++i){
                res.add(matrix[i][right]);
            }

            if (left<right&&top<botten){
                for (int i=right-1;i>left;i--){
                    res.add(matrix[botten][i]);
                }

                for (int i=botten;i>top;i--){
                    res.add(matrix[i][left]);
                }
            }
            top++;
            botten--;
            left++;
            right--;
        }

        return res;
    }

    @Test
    public void test(){
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}
