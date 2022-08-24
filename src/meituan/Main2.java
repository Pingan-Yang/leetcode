package meituan;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/13 16:26
 * @Version:1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];
        String[] split = sc.nextLine().split(" ");
        arr[0] = Integer.parseInt(split[0]);
        arr[1] = Integer.parseInt(split[1]);

        int[] endTines = new int[arr[0]];
        for (int i = 0; i < arr[0]; ++i) {
            endTines[i] = Integer.parseInt(sc.next());
        }
        Arrays.sort(endTines);
        int n = arr[0];
        int step = arr[1];
        int k = 1;
        int count = 0;

        if (step + endTines[0] >= endTines[n - 1]) {
            System.out.println(0);
        } else {
            for (int i=0;i<n;++i){
                if (step + endTines[0]<endTines[i]){
                    count++;
                }
            }
            System.out.println(count);

        }

    }
}
