package hot100;

import java.util.Arrays;

/**
 * @ClassName leetcode62
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/1 10:54
 * @Version:1.0
 */
public class leetcode62 {
    public static int uniquePaths(int m, int n) {

        /**                                   左一个格子向右走一步 (走到前一个格子得走法)   i＝0，
         *
         *                                    上一个格子向下走一步(走到前一个格子得走法)    j=0
         *   当前格子一共有得走法===
         *
         *                                    左一个格子向右走一步 (走到前一个格子得走法)+ 上一个格子向下走一步(走到前一个格子得走法) 0<i<m,0<j<n-1
         */

        int[][] countPaths=new int[m][n];
        for (int[] row:countPaths){
            System.out.println(Arrays.toString(row));
        }
        // 初始化第一列为1
        for (int i=0;i<m;++i){
            countPaths[i][0]=1;
        }
        // 初始化第一行为1；
        for (int j=0;j<n;++j){
            countPaths[0][j]=1;
        }
        for (int i=1;i<m;++i){
            for (int j=1;j<n;++j){
                countPaths[i][j]=countPaths[i-1][j]+countPaths[i][j-1];
            }
        }
        return countPaths[m-1][n-1];
    }

    public static void main(String[] args) {
        int i = uniquePaths(3, 7);
        System.out.println(i);
    }
}
