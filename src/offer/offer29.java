package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName offer29
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/8 22:06
 * @Version:1.0
 */
public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];

        int l = 0;//左边界
        int r = n - 1;//右边界
        int t = 0;//上边界
        int b = m - 1;//下边界
        int x = 0;//数组下标

        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // 从左到右
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // 从上到下
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // 从右到左
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // 从下到上.
            if (++l > r) break;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}};

        int[] order = spiralOrder(matrix);
        System.out.println(Arrays.toString(order));
    }
}
