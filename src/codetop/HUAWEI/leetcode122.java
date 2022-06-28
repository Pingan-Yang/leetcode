package codetop.HUAWEI;

/**
 * @ClassName leetcode122
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/21 22:35
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */
public class leetcode122 {
    /**
     * 贪心：碰到比当天贵的就卖出去
     */
    public int maxProfit1(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (prices[i + 1] - prices[i] > 0) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }

    /**
     * 动态规划：
     * 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     * 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
     * dp[i][0]=max{dp[i-1][0],dp[i-1][1]+price[i]}
     * ①：前一天手里已经没有股票了  dp[i-1][0]
     * ②：前一天手里有股票，但是今天卖出去了   dp[i-1][1]+price[i]
     * dp[i][1] :
     * ①：前一天手里就有一只股票  dp[i-1][1]
     * ②：前一天手里没有股票但是今天买入了  dp[i-1][0]-price[i]
     * <p>
     * 初始化：dp[0][0]=0 dp[0][1]=-price[0];
     * 全部交易结束后，持有股票的收益一定低于不持有股票的收益，return dp[n-1][0]
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    /**
     * 优化
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int dp0=0;
        int dp1=-prices[0];

        for (int i = 1; i < n; ++i) {
            int newdp0=Math.max(dp0,dp1+prices[i]);
            int newdp1=Math.max(dp1,dp0-prices[i]);
            dp0=newdp0;
            dp1=newdp1;
        }
        return Math.max(dp0,dp1);
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
