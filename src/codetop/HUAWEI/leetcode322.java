package codetop.HUAWEI;

/**
 * @ClassName leetcode322
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 20:17
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;


/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class leetcode322 {
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        //dp[i][j]:考虑前i个硬币，可以凑成总金额j所需的 最少的硬币个数
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < amount + 1; ++i) {
            dp[0][i] = amount + 1;//amount+1表示无解
        }
        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; ++i) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; ++j) {
                if (coin > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
            }
        }

//        for (int[] f : dp) {
//            System.out.println(Arrays.toString(f));
//        }

        int lastElement = dp[n][amount];
        return lastElement == amount + 1 ? -1 : lastElement;

    }

    //优化成一维数组
    public int coinChange(int[] coins, int amount) {
        // dp[i]:代表需要面值为i的最小硬币数
        // dp[i]=min(dp[i],dp[i-coin]+1)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] coins = {2};
        int amount = 3;
        int ans = coinChange2(coins, amount);
        System.out.println(ans);//3
    }

    public int coinChange2(int[] coins, int amount) {
        //dp[i][j]:考虑前i种硬币，凑成总金额的j的最少硬币个数
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i < amount + 1; ++i) {
            dp[0][i] = amount + 1;//amount+1表示无解
        }
        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        int lastElement = dp[n][amount];
        return lastElement == amount + 1 ? -1 : lastElement;
    }


}
