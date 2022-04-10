package hot100;

/**
 * @ClassName leetcode48
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/10 20:09
 * @Version:1.0
 */
public class leetcode48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        if (n==1){
            return;
        }
        // 暴力法
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[j][n-1-i]=matrix[i][j];
            }
        }
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                matrix[i][j]=temp[i][j];
            }
        }

    }
}
