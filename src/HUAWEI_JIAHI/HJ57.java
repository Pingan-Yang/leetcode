package HUAWEI_JIAHI;

/**
 * @ClassName HJ57
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/8 19:40
 * @Version:1.0
 */

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 高精度整数加法
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和
 *
 * 数据范围： 1≤len(str)≤10000
 *
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 *
 * 输出描述：
 * 输出求和后的结果
 */
public class HJ57 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();

            BigDecimal value1 =new BigDecimal(s1);
            BigDecimal value2 =new BigDecimal(s2);
            System.out.println(value1.add(value2));
        }
    }
}
