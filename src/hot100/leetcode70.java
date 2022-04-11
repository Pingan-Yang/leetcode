package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode70
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/11 20:01
 * @Version:1.0
 */
public class leetcode70 {
    public int climbStairs(int n) {
        // dp[i]:代表爬到第i阶台阶有多少种方法
        if(n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i=2;i<n;++i){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        int n=3;
        int climbStairs = climbStairs(n);
        System.out.println(climbStairs);
    }
}
