package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode64
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/11 19:41
 * @Version:1.0
 */
public class leetcode64 {
    public int minPathSum(int[][] grid) {
        // dp[i][j]:表示到达{i，j}位置时的路径总合
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        // 初始化
        dp[0][0]=grid[0][0];
        for (int i=1;i<n;++i){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i=1;i<m;++i){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for (int i=1;i<m;++i){
            for (int j=1;j<n;++j){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];

    }
    @Test
    public void test(){
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int minPathSum = minPathSum(grid);
        System.out.println("minPathSum:"+minPathSum);
    }
}
