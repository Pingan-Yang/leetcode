package codetop.HUAWEI;

/**
 * @ClassName leetcode264
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/20 21:38
 * @Version:1.0
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. 丑数 II:
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class leetcode264 {
    /**
     * 小根堆
     */
    public int nthUglyNumber1(int n) {
        int[]factors ={2,3,5};
        PriorityQueue<Long>heap=new PriorityQueue<>();
        HashSet<Long>set=new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        int ugly=0;
        for (int i=0;i<n;++i){
            long cur=heap.poll();
            ugly=(int)cur;
            for (int factor:factors){
                long next=cur*factor;
                if (!set.contains(next)){
                    heap.offer(next);
                    set.add(next);
                }

            }
        }
        return ugly;
    }
    /**
     *动态规划
     * dp[i] 表示第 i 个丑数
     * 由于最小的丑数是 1，dp[1]=1。
     * 定义三个指针 p2,p3,p5表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都是 1。
     * 当  2≤i≤n 时，令 dp[i]=min(dp[p2]*2,dp[p3]*3,dp[p5]*5)
     *

     */
    public int nthUglyNumber(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;

        int p2=1,p3=1,p5=1;
        for (int i=2;i<=n;++i){
            int num2=dp[p2]*2;
            int num3=dp[p3]*3;
            int num5=dp[p5]*5;
            dp[i]=Math.min(num2,Math.min(num3,num5));
            if (dp[i]==num2){
                p2++;
            }
            if (dp[i]==num3){
                p3++;
            }
            if (dp[i]==num5){
                p5++;
            }
        }

        return dp[n];
    }

    @Test
    public void test(){
        int n=10;
        int number = nthUglyNumber(n);
        System.out.println(number);
    }

}
