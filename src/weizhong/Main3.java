package weizhong;


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * 小明刚刚学会用动态规划方法解决最长上升子序列（LIS）问题。
 * LIS 的 O(n2) 动态规划解法是这样的：
 * 设 dp[i] 为以 i 结尾的最长上升子序列的长度，首先令所有的 dp[i] = 1，
 * 转移由 dp[j] 转移过来，要求 j ∈ [1, i − 1] 且 aj < ai。
 * 转移方程就是dp[i] = max(dp[i], dp[j] + 1)。最后 max dp[i] 就是答案。
 * <p>
 * 1≤j<i                                    1≤i≤n
 * <p>
 * 明现在想知道：有多少个长度为 n 的整数序列，每个整数都在 [1, m] 之内，且这个序列的最长上升子序列的长度恰好等于3？
 * 由于答案可能会很大，求得的结果对998244353 取模即可。
 * <p>
 * 4  3
 * 9
 */
public class Main3 {
    static int m, n;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] nums = new int[n];
        dfs(nums, 0);
        System.out.println(res % 998244353);
    }

    private static void dfs(int[] nums, int deep) {
        if (deep == nums.length) {
            int temp = getMax(n, nums);
            if (temp == 3) {
                res++;
            }
            return;
        }
        for (int i = 1; i <= m; i++) {
            nums[deep] = i;
            dfs(nums, deep + 1);
        }
        return;
    }

    private static int getMax(int n, int[] nums) {
        int ret = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
