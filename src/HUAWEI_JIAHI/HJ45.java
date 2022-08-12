package HUAWEI_JIAHI;

/**
 * @ClassName HJ45
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/4 11:11
 * @Version:1.0
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
 * 第一行一个整数N，接下来N行每行一个字符串
 *
 * 每个字符串可能的最大漂亮程度
 */
public class HJ45 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String[] strings=new String[n];
            for (int i=0;i<n;++i){
                strings[i]=sc.next();
            }
            int[] res=process(strings);
            for (int i=0;i<n;++i){
                System.out.println(res[i]);
            }
        }
    }

    private static int[] process(String[] strings) {
        int[] mbv=new int[strings.length];
        int k=0;
        for (String s:strings){
            char[] chars = s.toCharArray();
            int[] index=new int[128];
            for (int i=0;i<chars.length;++i) {
                index[chars[i]]++;
            }
            Arrays.sort(index);
            int mul=26,sum=0;
            for (int j=index.length-1;j>=0&&index[j]>0;j--){
                sum+=index[j]*mul;
                mul--;
            }
            mbv[k++]=sum;
        }
        return mbv;
    }
}
