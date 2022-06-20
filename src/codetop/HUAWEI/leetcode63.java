package codetop.HUAWEI;

import org.junit.Test;

/**
 * @ClassName leetcode63
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/19 10:26
 * @Version:1.0
 */
public class leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        //初始化
        for(int i=0;i<n;++i){
           if (obstacleGrid[0][i]==1){
               dp[0][i]=0;
               break;
           }
            dp[0][i]=1;
        }
        for (int i=0;i<m;++i){
            if (obstacleGrid[i][0]==1){
                dp[i][0]=0;
                break;
            }
            dp[i][0]=1;
        }

       for (int i=1;i<m;++i){
           for (int j=1;j<n;++j){
               if (obstacleGrid[i][j]==1){
                   dp[i][j]=0;
               }else{
                   dp[i][j]=dp[i-1][j]+dp[i][j-1];
               }
           }
       }
       return dp[m-1][n-1];

    }

    @Test
    public void test(){
        int[][]obstacleGrid={
                {0,0,0},{0,1,0},{0,0,0}
        };
        int ans = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
}
