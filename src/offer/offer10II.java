package offer;

/**
 * @ClassName offer10II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 19:39
 * @Version:1.0
 */
public class offer10II {
    public int numWays(int n) {
        //迭代
       if (n==0){
           return 1;
       }
       if (n<=2){
           return n;
       }
       int a=1;
       int b=2;
       int mod=1000000007;
       int ans=0;
       for (int i=3;i<=n;++i){
           ans=(a+b)%mod;
           a=b;
           b=ans;
       }
       return ans;
    }
}
