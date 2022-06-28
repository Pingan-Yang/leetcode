package codetop.HUAWEI;

/**
 * @ClassName leetcode650
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/28 11:02
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 650. 只有两个键的键盘
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。

 */
public class leetcode650 {
    /**
     * 动态规划：
     *      定义 f[i][j] 为经过最后一次操作后，当前记事本上有 i 个字符，粘贴板上有 j 个字符的最小操作次数。
     *      由于我们粘贴板的字符必然是经过 Copy All 操作而来，因此对于一个合法的 f[i][j] 而言，必然有 j<=i。
     *  转移方程：
     *      最后一次操作是 Paste 操作：此时粘贴板的字符数量不会发生变化，即有 f[i][j]=f[i−j][j]+1；
     *
     *      最后一次操作是 Copy All 操作：那么此时的粘贴板的字符数与记事本上的字符数相等（满足 i=j），
     *      此时的f[i][j]=min(f[i][x]+1),0≤x<i。
     *
     *      我们发现最后一个合法的 f[i][j]（满足 i = j）依赖与前面 f[i][j]（满足 j<i）。
     *
     *      因此实现上，我们可以使用一个变量 min 保存前面转移的最小值，用来更新最后的 f[i][j]。
     *
     *      再进一步，我们发现如果 f[i][j] 的最后一次操作是由 Paste 而来，原来粘贴板的字符数不会超过 i/2，
     *      因此在转移f[i][j]（满足 j<i）时，其实只需要枚举 [0,i/2] 即可。
     *
     *
     */
    int INF= Integer.MAX_VALUE/2;
    public int minSteps(int n) {
        int[][]dp=new int[n+1][n+1];
        for (int i=0;i<=n;++i){
            for (int j=0;j<=n;++j){
                dp[i][j]=INF;
            }
        }
        dp[1][0]=0;
        dp[1][1]=1;
        for (int i=2;i<=n;++i){
            int min=INF;
            for (int j=0;j<=i/2;++j){
                dp[i][j]=dp[i-j][j]+1;
                min=Math.min(min,dp[i][j]);
            }
            dp[i][i]=min+1;
        }
        int ans=INF;
        for (int i=0;i<=n;++i){
            ans=Math.min(ans,dp[n][i]);
        }
        return ans;
    }



    @Test
    public void test(){
        int n=4;
        int ans = minSteps(n);
        System.out.println(ans);
    }
}
