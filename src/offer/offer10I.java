package offer;

/**
 * @ClassName offer10I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 19:33
 * @Version:1.0
 */
public class offer10I {
    public int fib(int n) {
        //迭代
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int a=0;
        int b=1;
        int ans=0;
        int mod=1000000007;
        for (int i=2;i<=n;++i){
            ans=(a+b)%mod;
            a=b;
            b=ans;
        }
        return ans;
    }
}
