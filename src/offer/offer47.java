package offer;

import org.junit.Test;

/**
 * @ClassName offer47
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/22 15:04
 * @Version:1.0
 */
public class offer47 {
    public int maxValue(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        //dp[i][j]:代表该位置能拿到的最大价值
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //初始化
        dp[0][0]=grid[0][0];
        for (int i=1;i<n;++i){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i=1;i<m;++i){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        // 开始dp
        for (int i=1;i<m;++i){
            for (int j=1;j<n;++j){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    @Test
    public void test(){
        int[][] grid={
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int maxValue = maxValue(grid);
        System.out.println(maxValue);
    }
}
