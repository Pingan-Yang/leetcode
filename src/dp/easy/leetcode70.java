package dp.easy;

/**
 * @ClassName leetcode70
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/8 20:28
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class leetcode70 {

    /**
     *迭代
     */
    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int p=1;
        int q=2;
        int ans=0;
        for (int i=3;i<=n;++i){
            ans=p+q;
            p=q;
            q=ans;
        }
        return ans;
    }

    @Test
    public void test(){
        int n=4;
        System.out.println(climbStairs(n));
    }
}
