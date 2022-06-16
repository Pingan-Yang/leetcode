package codetop.HUAWEI;

/**
 * @ClassName offer10II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 20:04
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 青蛙跳台阶：
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class offer10II {
    public int numWays(int n) {
        final int mod= 1000000007;

        if (n<=2){
            return n==0?1:n;
        }

        int p=1;
        int q=2;

        int res=0;
        for (int i=3;i<=n;++i){
            res=(p+q)%mod;
            p=q;
            q=res;
        }
        return res;

    }
    @Test
    public void test(){
        int n=7;
        int numWays = numWays(n);
        System.out.println(numWays);
    }
}
