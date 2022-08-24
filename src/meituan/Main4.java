package meituan;

/**
 * @ClassName Main4
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 10:33
 * @Version:1.0
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美即将进行期末考试！
 * 小美现在盘算了一下，一共有n道试题，对于第 i 道试题，小美有着pi的概率做对，获得ai的分值，另外(1-pi)的概率做错，获得0分。
 * 小美的总分即是每道题获得的分数之和。小美不甘于此！
 * 她决定突击复习，因为时间有限，她最多复习m道试题，使得复习后的试题正确率提升到100%。
 * 小美想知道，如果她以最佳方式进行复习，能获得的期望总分最大是多少
 * <p>
 * 第一行两个正整数n和m，表示总试题数和最多复习试题数。
 * <p>
 * 接下来一行n个整数，分别为p1 p2...pn，表示小美有pi%的概率，即pi=pi/100的概率做对第i个题。（注意，这里为了简单起见，将概率pi扩张100倍成为整数pi方便输入）
 * <p>
 * 接下来一行n个整数，分别表示a1 a2...an，分别表示第 i 个题做对的分值。
 * <p>
 * 数字间两两有空格隔开，对于所有数据，1≤m≤n≤50000,0≤pi≤100,1≤ai≤1000
 * <p>
 * <p>
 * 2 1
 * 89 38
 * 445 754
 * <p>
 * 1150.05
 * <p>
 * <p>
 * 如果都不复习，小美总分的期望为89%*445+38%*754=682.57
 * <p>
 * 如果复习第一道题，小美总分的期望为100%*445+38%*754=731.52
 * <p>
 * 如果复习第二道题，小美总分的期望为89%*445+100%*754=1150.05
 * <p>
 * 所以选择复习第二道题，这样能获得最大期望总分1150.05
 * <p>
 *
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总题数
        int n = Integer.parseInt(sc.next());
        //最多复习
        int m = Integer.parseInt(sc.next());

        //概率和分值
        int[] p = new int[n];
        int[] a = new int[n];
        Grade[] grades = new Grade[n];
        for (int i = 0; i < n; ++i) {
            p[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(sc.next());
        }

//----------------------------------------------------------------
//        for (int i=0;i<n;++i){
//            grades[i]=new Grade(Double.parseDouble("0."+p[i]),a[i]);
//        }
//
//        Arrays.sort(grades,(g1,g2)->{
//
//           return g1.a==g2.a?(int) (g1.p-g2.p):g2.a-g1.a;
//        });
//
//        double ans=0.0d;
//        for (int i=0;i<n;++i){
//            if (i<m){
//                ans+=grades[i].a;
//            }else{
//                ans+=(grades[i].a*grades[i].p);
//            }
//        }
//        System.out.println(ans);

        double start = 0.0d;

        for (int i = 0; i < n; ++i) {
            start += p[i] / 100.0 * a[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = m; j >= 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + ((100 - p[i]) / 100.0) * a[i]);
            }
        }
        System.out.println(dp[m] + start);
    }
}

class Grade {
    double p;//概率
    int a;//成绩

    public Grade() {
    }

    public Grade(double p, int a) {
        this.p = p;
        this.a = a;
    }
}
