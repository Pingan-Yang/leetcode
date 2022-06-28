package codetop.HUAWEI;

/**
 * @ClassName leetcode132
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/28 20:58
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 */
public class leetcode132 {


    //超时了
    List<List<String>> res=new ArrayList<>();
    List<String>list=new ArrayList<>();
    boolean[][] dp;
    public int minCut1(String s) {
        int n=s.length();
        dp=new boolean[n][n];
        for (int i=0;i<n;++i){
            dp[i][i]=true;
        }
        char[] array = s.toCharArray();
        for (int j=1;j<n;++j){
            for (int i=0;i<=j;++i){
                if (array[i]!=array[j]){
                    dp[i][j]=false;
                }else{
                    if (j-i<=2){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

            }
        }
        dfs(s,0);
        int ans=Integer.MAX_VALUE;
        for (List<String>l:res){
            ans=Math.min(ans,l.size());
        }
        return ans-1;

    }
    private void dfs(String s, int start) {
        //dfs结束条件：start已经到末尾了
        if (start==s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }

        //开始遍历
        for (int i=start;i<s.length();++i){
            if (dp[start][i]){
                list.add(s.substring(start,i+1));
                dfs(s,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     *动态规划；dp[i]:表示字符串的前缀 s[0..i] 的最少分割次数。
     * 以考虑枚举 s[0..i] 分割出的最后一个回文串，这样我们就可以写出状态转移方程：
     * dp[i]=min(dp[i])+1  0<≤j＜i
     * 即我们枚举最后一个回文串的起始位置 j+1，保证 s[j+1..i] 是一个回文串，那么 dp[i] 就可以从 dp[j] 转移而来，附加 1 次额外的分割次数。
     * 注意到上面的状态转移方程中，我们还少考虑了一种情况，即 s[0..i] 本身就是一个回文串。此时其不需要进行任何分割，即：
     * dp[i]=0
     */
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for (int i=0;i<n;++i){
            dp[i][i]=true;
        }
        char[] array = s.toCharArray();
        for (int j=1;j<n;++j){
            for (int i=0;i<=j;++i){
                if (array[i]!=array[j]){
                    dp[i][j]=false;
                }else{
                    if (j-i<=2){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

            }
        }
        int[] f=new int[n];
        Arrays.fill(f,Integer.MAX_VALUE);
        for (int i=0;i<n;++i){
            if (dp[0][i]){
                f[i]=0;
            }else{
                for (int j=0;j<i;++j){
                    if (dp[j+1][i]){
                        f[i]=Math.min(f[i],f[j]+1);
                    }
                }
            }
        }
        return f[n-1];
    }
    @Test
    public void test(){
        String s="ababababababababababababcbabababababababababababa";
         //String s="ababababab";
        int minCut = minCut(s);
        System.out.println(minCut);
    }
}
