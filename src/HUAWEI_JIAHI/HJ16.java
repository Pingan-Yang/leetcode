package HUAWEI_JIAHI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName HJ16
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/23 14:21
 * @Version:1.0
 */
public class HJ16 {
}

/**
 * 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 *
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。
 * 他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 *
 * 输入的第 1 行，为两个正整数N，m，用一个空格隔开：
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 * 其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件
 * 。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号
 *
 * 输出一个正整数，为张强可以获得的最大的满意度。
 *
 */
 class Main16 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            //可使用的金钱
            int money = sc.nextInt();
            //可以购买的物品数量
            int m = sc.nextInt();
           // sc.nextLine();
            money /= 10;
            int[][] prices = new int[m + 1][3];
            int[][] weights = new int[m + 1][3];
            for (int i = 1; i <= m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                a /= 10;//price
                b = b * a;//weight
                if (c == 0) {
                    // 主件
                    prices[i][0] = a;
                    weights[i][0] = b;
                } else if (prices[c][1] == 0) {
                    // 附件1
                    prices[c][1] = a;
                    weights[c][1] = b;
                } else {
                    // 附件2
                    prices[c][2] = a;
                    weights[c][2] = b;
                }
                sc.nextLine();
            }
            int[][] dp = new int[m + 1][money + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= money; j++) {
                    int a = prices[i][0];
                    int b = weights[i][0];
                    int c = prices[i][1];
                    int d = weights[i][1];
                    int e = prices[i][2];
                    int f = weights[i][2];

                    dp[i][j] = j - a >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - a] + b) : dp[i - 1][j];
                    dp[i][j] = j - a - c >= 0 ? Math.max(dp[i][j], dp[i - 1][j - a - c] + b + d) : dp[i][j];
                    dp[i][j] = j - a - e >= 0 ? Math.max(dp[i][j], dp[i - 1][j - a - e] + b + f) : dp[i][j];
                    dp[i][j] = j - a - c - e >= 0 ? Math.max(dp[i][j], dp[i - 1][j - a - c - e] + b + d + f) : dp[i][j];
                }
            }

            System.out.println(dp[m][money] * 10);
        }

    }
}
