package dp.easy;

/**
 * @ClassName leetcode509
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/9 16:00
 * @Version:1.0
 */

/**
 * 斐波那契数：给定n 计算F（n）
 */
public class leetcode509 {
    public int fib(int n) {
        if (n<=1){
            return n;
        }
        int p=0;
        int q=1;
        int ans=0;
        for (int i=2;i<=n;++i){
            ans=p+q;
            p=q;
            q=ans;
        }
        return ans;
    }
}
