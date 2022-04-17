package offer;

import org.junit.Test;

/**
 * @ClassName offer04
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 21:51
 * @Version:1.0
 */
public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if(matrix==null||m==0){
            return false;
        }
        int n = matrix[0].length;
        if(matrix[0]==null||n==0){
            return false;
        }
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean isExist = findNumberIn2DArray(matrix, 90);
        System.out.println(isExist);

    }
}
