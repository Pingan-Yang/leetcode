package dp.dpmodel;

/**
 * @ClassName model2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/1 20:06
 * @Version:1.0
 */

/**
 * 完全背包问题：
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 * 第 i 种物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class model2 {

    public static void main(String[] args) {
        int N = 4, V = 5;
        int[] w = {1, 2, 3, 4};
        int[] v = {2, 4, 4, 5};
        int maxValue = method2(N, V, w, v);
        System.out.println("maxValue:" + maxValue);
    }


    /**
     *          max{f[i][v-w[i]]+v[i],f[i-1][v]}  v-w[i]≥0
     * f[i][v]=
     *          f[i-1][v]  otherwise
     */
    public static int method1(int N, int V, int[] w, int[] v) {

        int[][] f = new int[N + 1][V + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= V; ++j) {
                f[i][j] = f[i - 1][j];
                //第i个物品的重量 weight[i-1]
                if (j - w[i - 1] >=0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - w[i - 1]]+v[i-1]);
                }
            }
        }
        int res = 0;
        for (int k = 0; k <= V; ++k) {
            res = Math.max(res, f[N][k]);
        }

        return f[N][V];
    }

    /**
     *
     */
    public  static int method2(int N, int V, int[] w, int[] v){
        int[] f = new int[V + 1];
        //开始状态转移
        for (int i = 1; i <= N; ++i) {
            for (int j = w[i-1]; j<=V; ++j) {
                f[j] = Math.max(f[j], f[j - w[i-1]] + v[i-1]);
            }
        }
        return f[V];
    }

}

/**
 * 两种决策方式：
 * ①：不放第i件物品
 * ②：放k件第i个物品
 * ===>f[i][v]:代表只考虑前i件物品 体积为j的情况下 的最大价值
 * 状态转移方程：f[i][v]=max{max{f[i-1][v-k*v[i]+k*w[i]},f[i-1][v]}(1≤k≤v/v[i])
 * <p>
 * 对于状态转移方程可简化为：
 * f[i][v]=max{f[i-1][v-k*v[i]+k*w[i]}(0≤k≤v/v[i])
 * <p>
 * 由于在第二种决策下，至少放一件，那我们不妨先吧这一件给放进去
 * f[i][v]=max{max{f[i-1][v-v[i]-k*v[i]+k*w[i]+w[i]},f[i-1][v]}(0≤k≤v/v[i]-1)
 * <p>
 * 当v=v-v[i]时
 * f[i][v-v[i]]=max(f[i-1][v-v[i]-k*v[i]]+k*w[i]) (0≤k≤v/v[i]-1)
 * <p>
 * ==>比较最后两个表达式可知：
 * f[i][v]=max{f[i][v-v[i]]+w[i],dp[i-1][v]}
 * <p>
 * <p>
 * w[i]表示第i个物品的重量，v[i]代表第i个物品的价值
 * 0-1背包问题的状态转移方程：{
 * max{f[i-1][v-w[i]]+v[i],f[i-1][v]}  v-w[i]≥0
 * f[i][v]=
 * f[i-1][v]  otherwise
 * <p>
 * <p>
 * 一维dp滚动数组
 * max{f[v-w[i]]+v[i],f[v]}  v-w[i]≥0
 * f[v]=
 * dp[v] otherwise
 * }
 * <p>
 * 完全背包问题状态转移方程：{
 * max{f[i][v-w[i]]+v[i],f[i-1][v]}  v-w[i]≥0
 * f[i][v]=
 * f[i-1][v]  otherwise
 * <p>
 * <p>
 * 一维dp滚动数组 :同0-1背包问题一样（除了v的枚举方向，完全背包问题要沿着V的正方向进行枚举，这样才能为接下来的状态提供充足的信息）
 * *          max{f[v-w[i]]+v[i],f[v]}  v-w[i]≥0
 * *    f[v]=
 * *          dp[v] otherwise
 * <p>
 * }
 */
