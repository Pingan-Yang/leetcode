package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode50
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/16 11:06
 * @Version:1.0
 */
public class leetcode50 {
    public double myPow(double x, int n) {
        if (x==0.0f){
            return 0.0d;
        }

        long b=n;
        double res=1.0;
        if (b<0){
            x=1/x;
            b=-b;
        }

        while (b>0){
            if ((b&1)==1){
               res*=x;
            }
            x*=x;
            b>>=1;
        }

        return  res;
    }

    /**
     * 这样不行 n太大会stackoverflow
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n){
        if (x==0.0f){
            return 0.0d;
        }

        long b=n;
        double res=1.0;
        if (b<0){
            x=1/x;
            b=-b;
        }

        return process( x, b);
    }

    private double process(double x, long n) {
        if (n==0){
            return 1.0d;
        }

        return x*process(x,n-1);
    }

    @Test
    public  void test(){
//        double x = 2.00000;
//        int n = 10;

        double x = 0.00001;
        int n=2147483647;
        double pow = myPow(x, n);
        System.out.println(pow);
    }

}
