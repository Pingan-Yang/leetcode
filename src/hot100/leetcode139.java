package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode139
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 20:22
 * @Version:1.0
 */
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()==0||wordDict==null||wordDict.size()==0){
            return false;
        }
        //dp[i]:表示字符串 s前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分成若干个字典中出现的单词
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i=0;i<n;++i){
            if (!dp[i]){
                continue;
            }
            for (String word:wordDict){
                if (i+word.length()<n&&s.startsWith(word,i)){
                    dp[i+word.length()]=true;
                }
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        String s="applepenapple";
        List<String>wordDict=new ArrayList<>(Arrays.asList("apple","pen"));
        boolean wordBreak = wordBreak(s, wordDict);
        System.out.println(wordBreak);
    }
}
