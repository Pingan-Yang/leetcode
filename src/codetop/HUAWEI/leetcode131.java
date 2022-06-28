package codetop.HUAWEI;

/**
 * @ClassName leetcode131
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/28 20:25
 * @Version:1.0
 */

import offer.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class leetcode131 {
    public List<String> partitiontest(String s) {
       // List<List<String>> res=new ArrayList<>();
        List<String>list=new ArrayList<>();
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
                if (dp[i][j]){
                    list.add(s.substring(i,j+1));
                }
            }
        }
        return list;
    }

    /**
     *由于需要求出字符串 s 的所有分割方案，因此我们考虑使用搜索 + 回溯的方法枚举所有可能的分割方法并进行判断
     *
     * 假设我们当前搜索到字符串的第 i 个字符，且 s[0..i−1] 位置的所有字符已经被分割成若干个回文串，并且分割结果被放入了答案数组 ans 中，
     *
     * 那么我们就需要枚举下一个回文串的右边界 j，使得s[i..j] 是一个回文串。
     *
     * 因此，我们可以从 i 开始，从小到大依次枚举 j。
     *
     * 对于当前枚举的 j值，判断 s[i..j] 是否为回文串：如果 s[i..j] 是回文串，ans 中，并以 j+1 作为新的 i 进行下一层搜索，
     *
     * 并在未来的回溯时将 s[i..j] 从 ans 中移除。
     */
    List<List<String>> res=new ArrayList<>();
    List<String>list=new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
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
        return res;
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

    @Test
    public void test(){
        String s="abb";
        List<List<String>> ans = partition(s);
        System.out.println(ans);
    }
}
