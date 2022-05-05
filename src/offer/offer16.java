package offer;

import org.junit.Test;

/**
 * @ClassName offer16
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/4 10:08
 * @Version:1.0
 */
public class offer16 {
    public double myPow(double x, int n) {
        //求 x^nx
        //n
        //  最简单的方法是通过循环将 nn 个 xx 乘起来，依次求 x^1, x^2, ..., x^{n-1}, x^n，时间复杂度为 O(n)O(n)

        //快速幂法 可将时间复杂度降低至 O(log_2 n)

        // 变量 n∈[−2147483648,2147483647] ，因此当 n = -2147483648执行 n = -n会因越界而赋值出错。
        // 解决方法是先将 n存入 long 变量 b ，后面用 b 操作即可

        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //n&1 （与操作）： 判断 n 二进制最右一位是否为 1 ；
            if((b & 1) == 1) res *= x;
            x *= x;
            //n>>1 （移位操作）： n 右移一位（可理解为删除最后一位）
            b >>= 1;
        }
        return res;


    }

    @Test
    public void test(){
        double x=2.00000;
        int n=-2147483648;
        double v = myPow(x, n);
        System.out.println(v);
    }
}
