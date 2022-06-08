package offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName offer62
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/8 21:29
 * @Version:1.0
 */
public class offer62 {
    //约瑟夫环
    //利用链表模拟
    //执行用时：1043 ms在所有 Java 提交中击败了23.06%的用户
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     *动态规划：
     * 输入n,m ，记此约瑟夫环问题为 「n,m问题」 ，设解（即最后留下的数字）为 f(n)
     * 「n,m 问题」：数字环为 0,1,2,...,n−1 ，解为 f(n) ；
     * 「n-1,m 问题」：数字环为 0,1,2,...,n−1 ，解为 f(n-1) ；
     * 以此类推……
     *
     * 对于「n,m 问题」，首轮删除环中第 m 个数字后，得到一个长度为 n - 1的数字环。
     * 由于有可能 m > n ，因此删除的数字为 (m−1)%n ，删除后的数字环从下个数字（m%n ）开始，
     * 设 t=m%n ，可得数字环：
     * t,t+1,t+2,...,0,1,...,t−3,t−2
     * 删除一轮后的数字环也变为一个「n−1,m 问题」，观察以下数字编号对应关系
     *
     * [n-1,m问题]  --> [n,m问题删除后]
     *        0    --->     t+0
     *        1    --->     t+1
     *        ...  --->     ...
     *        n-2  --->     t-2
     *
     *  设「n−1,m 问题」某数字为 x ，则可得递推关系：x→(x+t)%n
     *  换而言之，若已知「n−1,m 问题」的解 f(n - 1)，则可通过以上公式计算得到「n,m 问题」的解 f(n) ，即：
     *  f(n)
     * =(f(n−1)+t)%n
     * =(f(n−1)+m%n)%n
     * =(f(n−1)+m)%n
     *
     * ​「1,m 问题」的解 f(1) = 0恒成立，即无论 m 为何值，长度为 1 的数字环留下的是一定是数字 0 。
     *动态规划解析：
     * 状态定义： 设「i,m 问题」的解为 dp[i]；
     * 转移方程： 通过以下公式可从 dp[i−1] 递推得到dp[i] :
     *      dp[i]=(dp[i−1]+m)%i
     *初始状态：「1,m 问题」的解恒为 0 ，即 dp[1] = 0；
     * 返回值： 返回「n, mn,m 问题」的解 dp[n]dp[n] ；
     */
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;

    }

    @Test
    public void test(){
        int i = lastRemaining(5, 3);
        System.out.println(i);
    }
}
