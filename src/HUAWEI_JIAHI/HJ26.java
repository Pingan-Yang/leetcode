package HUAWEI_JIAHI;

/**
 * @ClassName HJ26
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/2 11:24
 * @Version:1.0
 */


import java.io.IOException;

import java.util.*;

/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 *
 * 输入描述：
 *      输入字符串
 * 输出描述：
 *      输出字符串
 */
public class HJ26 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String res=process( s);
            System.out.println(res);
        }
    }

    private static String process(String s) {

        List<Character>list=new ArrayList<>();
        char[] chars = s.toCharArray();
        //将英文字母收集起来
        for (char c:chars){
            if (Character.isLetter(c)){
                list.add(c);
            }
        }
        //将英文字母排序
        Collections.sort(list,(o1,o2)->{
            return Character.toLowerCase(o1)-Character.toLowerCase(o2);
        });

        //非英文字直接添加
        StringBuilder sb=new StringBuilder();

        int n=s.length();
        for (int i = 0 , j=0; i <n ; i++) {
            if (Character.isLetter(chars[i])){
                sb.append(list.get(j++));
            }else{
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
