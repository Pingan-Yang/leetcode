package HUAWEI_JIAHI;

import java.util.Scanner;

/**
 * @ClassName HJ4
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/1 21:36
 * @Version:1.0
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() < 8) {
                int size = 8 - s.length();
                for (int i = 0; i < size; ++i) {
                    s = s + "0";
                }
                System.out.println(s);
            } else {
                for (int i = 0; i < s.length(); i += 8) {
                    if (i + 8 > s.length()) {
                        int size = i + 8 - s.length();
                        for (int j = 0; j < size; ++j) {
                            s = s + "0";
                        }
                        System.out.println(s.substring(i, i + 8));
                    } else {
                        System.out.println(s.substring(i, i + 8));
                    }

                }
            }
        }

    }
}


