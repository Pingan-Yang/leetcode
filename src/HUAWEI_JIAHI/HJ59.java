package HUAWEI_JIAHI;

/**
 * @ClassName HJ59
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/8 19:50
 * @Version:1.0
 */

import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 *
 *
 * 找出字符串中第一个只出现一次的字符
 *
 *
 * 数据范围： 1≤n≤1000
 *
 * 输入描述：
 * 输入一个非空字符串
 *
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 */
public class HJ59 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            int n=s.length();
            char ch='0';
            for (int i=0;i<n;++i){
                //看看 字符在字符串中出现的位置是否唯一
                if (s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                    ch=s.charAt(i);
                    break;
                }
            }
            if (ch=='0'){
                System.out.println("-1");
            }else{
                System.out.println(ch);
            }

        }
    }
}
