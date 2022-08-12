package HUAWEI_JIAHI;

/**
 * @ClassName HJ32
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/3 10:37
 * @Version:1.0
 */

import java.util.Scanner;

/**
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 数据范围：字符串长度满足1≤n≤2500
 *
 * 输入描述：
 * 输入一个字符串（字符串的长度不超过2500）
 *
 * 输出描述：
 * 返回有效密码串的最大长度
 */
public class HJ32 {
    //其实这一题考的是最大回文子串
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            int ans=maxLength(sc.nextLine());
            System.out.println(ans);
        }
    }

    private static int maxLength(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        //dp[i][j]:i~j是否是回文子串
        boolean [][]dp=new boolean[n][n];
        for (int i=0;i<n;++i){
            dp[i][i]=true;
        }

        int max=1;
        int start=0,end=0;
        for (int j=1;j<n;++j){
            for (int i=0;i<j;++i){
                if (chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else{
                    if (j-i<=2){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if (dp[i][j]){
                   max=Math.max(max,j-i+1);
                }
            }

        }
        return max;
    }
}
