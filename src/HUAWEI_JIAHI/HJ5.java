package HUAWEI_JIAHI;

import java.util.*;

/**
 * @ClassName HJ5
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/1 21:58
 * @Version:1.0
 */
public class HJ5 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String s = str.substring(2).toLowerCase();
            char[] arr = s.toCharArray();
            int res = 0;
            for (int i = 0; i < arr.length; ++i) {
                res += map.get(arr[i]) * Math.pow(16, arr.length - 1 - i);
            }
            System.out.println(res);
        }
    }

}
