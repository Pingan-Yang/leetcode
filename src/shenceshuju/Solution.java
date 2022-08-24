package shenceshuju;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Solution
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/19 17:07
 * @Version:1.0
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        Map<Integer, Integer> tree = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            tree.put(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
        }
        int node1 = Integer.parseInt(sc.next());
        int node2 = Integer.parseInt(sc.next());
        int k = node2;
        while (k != 1) {
            k = tree.get(k);
            if (k == node1 && k != 1) {
                System.out.println(node1);
                return;
            }

        }
        if (k==1){
            System.out.println("1");
            return;
        }
        k = node1;
        while (k!= 1) {
            k = tree.get(k);
            if (k == node2 && k != 1) {
                System.out.println(node2);
               return;
            }
        }
        if (k==1){
            System.out.println("1");
            return;
        }


//        int m = tree.get(node1);
//            k = tree.get(node2);
//        if (m == k) {
//            System.out.println(m);
//        } else {
//            while (true) {
//                k = tree.get(node2);
//                while (true) {
//                    m = tree.get(m);
//                    if (m == 1) {
//                        System.out.println("1");
//                        break;
//                    } else if (m == k) {
//                        System.out.println(m);
//                        break;
//                    }
//                }
//
//                if (m == k || m == 1) {
//                    break;
//                }
//                k = tree.get(k);
//                if (k == 1) {
//                    System.out.println("1");
//                    break;
//                }
//            }
//        }

    }
}
