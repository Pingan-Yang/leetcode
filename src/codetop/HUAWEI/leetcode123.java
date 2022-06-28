package codetop.HUAWEI;

/**
 * @ClassName leetcode123
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/27 15:48
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

public class leetcode123 {
    /**
     * 动态规划：dp[天数][当前是否持股][卖出的次数]
     * ① 未持股，未卖出过股票：说明从未进行过买卖，利润为0
     * dp[i][0][0]=0;
     * ②：未持股，卖出过1次股票：可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
     * dp[i][0][1]=max(dp[i-1][1][0]+price[i],dp[i-1][0][1]);
     * ③：未持股，卖出过2次股票:可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
     * dp[i][0][2]=max(dp[i-1][1][1]+price[i],dp[i-1][0][2]);
     * ④：持股，未卖出过股票：可能是今天买的，也可能是之前买的（昨天也持股）
     * dp[i][1][0]=max(dp[i-1][0][0]-price[i],dp[i-1][1][0]);
     * ⑤：持股，卖出过1次股票：可能是今天买的，也可能是之前买的（昨天也持股）
     * dp[i][1][1]=max(dp[i-1][0][1]-price[i],dp[i-1][1][1])
     * ⑥：持股，卖出过2次股票：最多交易2次，这种情况不存在
     * dp[i][1][2]=-∞；
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        dp[0][0][0]=0;
        dp[0][0][1] = Integer.MIN_VALUE/2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALU
        dp[0][0][2] = Integer.MIN_VALUE/2;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = Integer.MIN_VALUE/2;
        dp[0][1][2] = Integer.MIN_VALUE/2;

        for (int i = 1; i < n; ++i) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] =Integer.MIN_VALUE/2;
        }

        return Math.max((Math.max(dp[n - 1][0][1], dp[n - 1][0][2])), 0);
    }

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

    }
}
