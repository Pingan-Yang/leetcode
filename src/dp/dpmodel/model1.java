package dp.dpmodel;

/**
 * @ClassName model1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/26 21:32
 * @Version:1.0
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 01背包问题
 * 有 N 件物品和一个容量为 V 的背包，每件物品有各自的价值且只能被选择一次，要求在有限的背包容量下，装入的物品总价值最大。
 * <p>
 * 「0-1 背包」是较为简单的动态规划问题，也是其余背包问题的基础。
 * <p>
 * 动态规划是不断决策求最优解的过程，「0-1 背包」即是不断对第 i 个物品的做出决策，「0-1」正好代表不选与选两种决定。
 */
public class model1 {
    public static void main(String[] args) throws IOException {
        Read read = new Read();
        int v = read.nextInt();//背包容量V

        int n1 = read.nextInt();//n件物品
        int[] value = new int[n1];//每个物品的价值
        for (int i = 0; i < n1; ++i) {
            value[i] = read.nextInt();
        }

        int n2=read.nextInt();
        int[] weight = new int[n2];//每个物品的重量
        for (int i = 0; i < n2; i++) {
            weight[i]=read.nextInt();
        }
        //System.out.println("-----------------------------------------------------------");
        int maxvalue = method1(n1, v, weight, value);
        System.out.println("maxValue:" + maxvalue);

    }

    /**
     * 二维数组的解法-------后面可优化为一维数组
     * f[i][j]:代表只考虑前i件物品 体积为j的情况下 的最大价值
     * f[i][j]:
     * ①：不选第i个物品    f[i][j]=f[i-1][j];
     * ②：选第i个物品：    f[i][j]=f[i-1][j-weight[i]]+value[i];
     * ==>
     * max(①,②)
     * <p>
     * ==》ans=max(f[n][0-v])
     *
     *
     * 0-1背包问题的状态转移方程：{
     *                 max{f[i-1][v-w[i]]+v[i],dp[i-1][v]}  v-w[i]≥0
     *     f[i][v]=
     *                 f[i-1][v]  otherwise
     *  }
     *
     * @param n
     * @param v
     * @param weight
     * @param value
     * @return
     */
    public static int method1(int n, int v, int[] weight, int[] value) {
        int[][] f = new int[n + 1][v + 1];
        //开始状态转移
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= v; ++j) {
                f[i][j] = f[i - 1][j];
                //第i个物品的重量 weight[i-1]
                if (j >= weight[i - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //得到在考虑n个物品时，重量从0-v 此时最大价值即答案
        int res = 0;
        for (int i = 0; i <= v; ++i) {
            res = Math.max(res, f[n][i]);
        }

        return res;
    }


    /**
     * 优化成一维数组-->因为f[i][j] = f[i - 1][j]可以看出只和上一层有关
     * f[i]:体积为i的情况下的它的最大值价值为多少
     *
     *初始化时所有的f[i]=0===>f(v) 就是答案
     *如果初始化时f(0)=0 f(..)=负无穷==>就需要枚举
     *
     *k<v
     * f(k)=max_value;
     * f[0]=0==>f[weight[0]]=value[0]==>....
     *
     * f[v-k]=0=>f[v-k+weight[0]]=value[0]=>...
     *
     * @param n
     * @param v
     * @param weight
     * @param value
     * @return
     */
    public static int method2(int n, int v, int[] weight, int[] value) {
        int[] f = new int[v + 1];
        //开始状态转移
        for (int i = 1; i <= n; ++i) {
            //从大到小遍历f[j-weight[i-1]]肯定没有算过 ，那么他一定f[i-1]的状态
            for (int j = v; j >= weight[i - 1]; --j) {
                // f[i][j] = f[i - 1][j];
                //第i个物品的重量 weight[i-1]
                // f[i][j] = Math.max(f[i][j], f[i - 1][j - weight[i-1]] + value[i-1]);
                f[j] = Math.max(f[j], f[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return f[v];
    }


    @Test
    public void test() {
        int n = 4;
        int v = 5;
        int[] weight = {1, 2, 3, 4};
        int[] value = {2, 4, 4, 5};
        int maxValue = method2(n, v, weight, value);
        System.out.println("maxValue:" + maxValue);
    }
}

class Read {
    private BufferedReader bf;
    private StringTokenizer st;

    public Read() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
    }

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }
}

