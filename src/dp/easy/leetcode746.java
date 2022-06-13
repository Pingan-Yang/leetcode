package dp.easy;

/**
 * @ClassName leetcode746
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/9 16:04
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费
 *
 */
public class leetcode746 {
    /**
     *dp[i]:代表到第i阶台阶所花费的最小花费
     * dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
     */
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=dp[1]=0;
        for (int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }

    @Test
    public void test(){
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        int mincost = minCostClimbingStairs(cost);
        System.out.println(mincost);

    }
}
