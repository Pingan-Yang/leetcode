package meituan;

/**
 * @ClassName Main3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 10:27
 * @Version:1.0
 */

import java.util.Scanner;

/**
 * 小团想要自己来烤串！不过在烤串之前，需要串好烤串。小团有n个荤菜和n个素菜，他想按顺序分别一个荤菜一个素菜串起来，想请你帮他串好！
 * <p>
 * 给出两个长度分别为n的仅包含小写英文字母的串A和B，分别代表荤菜和素菜的种类（用字母来表示菜的种类）。
 * 请你以从左到右的顺序依次串好他们！例如对于荤菜串A1A2...An和素菜串B1B2...Bn，串好应该是A1B1A2B2...AnBn
 * <p>
 * <p>
 * 第一行一个正整数n，表示烤串长度
 * <p>
 * 第二行为一个长度为n的字符串A，表示荤菜按次序都是哪些菜。
 * <p>
 * 第三行为一个长度为n的字符串B，表示素菜按次序都是哪些菜。
 * <p>
 * 对于80%的数据，n≤1000
 * <p>
 * 对于20%的数据，n≤50000
 * <p>
 * 对于所有数据，A和B为仅包含小写英文字母的字符串。
 * <p>
 * 输出一行，包含2n个字符串表示串好的烤串。
 * <p>
 * <p>
 * 4
 * abcd
 * efgh
 * <p>
 * aebfcgdh
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String str1 = sc.next();
        String str2 = sc.next();
        StringBuilder sb = new StringBuilder();
        int len = str1.length();
        for (int i = 0; i < len; ++i) {
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
