package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode322
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/18 19:12
 * @Version:1.0
 */
public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
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
    public void test(){
        int[] coins={1,2,5};
        int amount=11;
        coinChange(coins,amount);
    }

}
