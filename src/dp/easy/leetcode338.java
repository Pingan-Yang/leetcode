package dp.easy;

/**
 * @ClassName leetcode338
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/8 21:08
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class leetcode338 {
    /**
     *暴力-这一题的bp没看
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int x=i;
            int count=0;
            while (x!=0){
                int flag=x&1;
                if (flag==1){
                    count++;
                }
               x= x>>>1;
            }
            ans[i]=count;
        }
        return ans;
    }

    /**
     * 另一种思路：
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
     *           0 = 0       1 = 1
     *          2 = 10      3 = 11
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
     * 因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，
     * 所以 1 的个数是不变的。
     *          2 = 10       4 = 100       8 = 1000
     *           3 = 11       6 = 110       12 = 1100
     *  另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
     *
     */
    public int[] countBits2(int n){
        int[] ans=new int[n+1];
        ans[0]=0;
        for (int i=1;i<=n;++i){
            if (i%2==1){
                ans[i]=ans[i-1]+1;
            }else{
                ans[i]=ans[i/2];
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int n=5;
        int[] bits = countBits2(n);
        System.out.println(Arrays.toString(bits));
    }
}
