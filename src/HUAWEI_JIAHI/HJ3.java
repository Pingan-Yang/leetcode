package HUAWEI_JIAHI;

import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HJ3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/1 21:30
 * @Version:1.0
 */
public class HJ3 {
}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            //第一个数字  或者该数字不等于前一个数字 都可以输出
            for (int i = 0; i < n; i++) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    System.out.println(arr[i]);
                }
            }

        }


    }


}