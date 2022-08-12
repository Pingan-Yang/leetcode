package HUAWEI_JIAHI;

/**
 * @ClassName HJ52
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/5 20:21
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Scanner;

/**
 * Levenshtein 距离，又称编辑距离，
 * 指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * 编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 *
 * 例如：
 *
 * 字符串A: abcdefg
 *
 * 字符串B: abcdef
 *
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 *
 * 要求：
 *
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 *
 *
 * 数据范围：给定的字符串长度满足 1≤len(str)≤1000
 *
 *
 * 输入描述：
 * 每组用例一共2行，为输入的两个字符串
 *
 * 输出描述：
 * 每组用例输出一行，代表字符串的距离
 *
 */
public class HJ52 {
    /**
     *dp[i][j]表示字符串A长度为i，字符串B长度为j时，对应的最小编辑距离。
     *A[0,...i-1]最后修改为B[0,...j-1]，有以下两种情况：
     * （一）A[i-1] == B[j-1]时，最后一个元素不用动，只用考虑A[0,...i-2]编辑为B[0,...j-2]需要的代价,dp[i][j] = dp[i-1][j-1]
     * （二）A[i-1]!=B[j-1]时，又可以分成以下三种情况：
     * 1、从A[0,...i-2]编辑为B[0,...j-1]，再删除A[i-1]
     * 2、从A[0,...i-1]编辑为B[0,...j-2]，再插入B[j-1]
     * 3、从A[0,...i-2]编辑为B[0,...j-2]，再将A[i-1]修改为B[j-1]
     * 每次取三种情况最小值
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            int m=s1.length();
            int n=s2.length();
            //dp[i][j]表示字符串A长度为i，字符串B长度为j时，对应的最小编辑距离。
            int[][]dp=new int[m+1][n+1];
            //初始化
            for (int i=1;i<=m;++i){
                dp[i][0]=i;
            }
            for (int j=1;j<=n;++j){
                dp[0][j]=j;
            }
            for (int i=1;i<=m;++i){
                for (int j=1;j<=n;++j){
                    if (s1.charAt(i-1)==s2.charAt(j-1)){
                        //如果相等，直接等于前一个位置的情况
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                       // 如果不相等，要么B字符串插入A中i位置对应字符即dp[i][j]=dp[i-1][j]+1
                        //要么A字符串插入B中j位置对应字符即dp[i][j]=dp[i][j-1]+1
                        // 要么s1字符串i位置字符被s2字符串j位置字符替换，即dp[i][j]=dp[i-1][j-1]+1
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
            }
            System.out.println(dp[m][n]);
        }

    }

//    @Test
//    public void test(){
//        StringBuilder sb=new StringBuilder("abc");
//        String str1 = sb.toString();
//        String str2="abc";
//        System.out.println(str1==str2);
//    }
}

