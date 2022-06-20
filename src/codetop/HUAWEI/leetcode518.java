package codetop.HUAWEI;

/**
 * @ClassName leetcode518
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 17:11
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 */
public class leetcode518 {
    /**
     * 动态规划：定义 dp[i][j]为考虑前 i 件物品，凑成总和为 j 的方案数量。
     * 为了方便初始化，我们一般让 dp[0][x] 代表不考虑任何物品的情况。
     * 初始化条件：dp[0][0]=1，其余 dp[0][x] = 0
     * 代表当没有任何硬币的时候，存在凑成总和为 0 的方案数量为 1；凑成其他总和的方案不存在。
     * 状态转移：
     * 不使用该硬币：f[i−1][j]
     * 使用该硬币：由于每个硬币可以被选择多次（容量允许的情况下），因此方案数量应当是选择「任意个」该硬币的方案总和：
     * f[i−1][j−k∗val],val=nums[i−1] 1<k<j/coins[i-1]
     */
    public int change1(int amount, int[] coins) {
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; ++i) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * val];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 优化成一维数组
     * 在二维解法的基础上，直接取消「物品维度」
     * 确保「容量维度」的遍历顺序为「从小到大」（适用于「完全背包」）
     * 将形如 f[i - 1][j - k * val] 的式子更替为 f[j - val]，同时解决「数组越界」问题（将物品维度的遍历修改为从 val开始）
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //用 dp[i] 表示金额之和等于 i 的硬币组合数
        int[] dp = new int[amount + 1];
        //dp[0]=1。只有当不选取任何硬币时，金额之和才为0，因此只有 1 种硬币组合。
        dp[0]=1;
        //对于面额为coin 的硬币，当 coin≤i≤amount 时，如果存在一种硬币组合的金额之和等于 i−coin，
        // 则在该硬币组合中增加一个面额为 coin 的硬币，即可得到一种金额之和等于 i 的硬币组合。因此需要遍历 coins，
        // 对于其中的每一种面额的硬币，更新数组 dp 中的每个大于或等于该面额的元素的值
        for (int i=1;i<=n;++i){
            int val=coins[i-1];
            for (int j=val;j<=amount;++j){
                dp[j]+=dp[j-val];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    @Test
    public void test(){
        int[] coins={1, 2, 5};
        int amount=5;
        int change = change(amount, coins);
        System.out.println(change);
    }
}
