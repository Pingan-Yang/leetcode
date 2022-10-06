package gaotu;

import hot100.ListNode;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        StringBuilder sb = new StringBuilder(n + "").reverse();
        char[] array = sb.toString().toCharArray();
        int len = array.length;
        Set<Character> set = new HashSet<>();
        List<Character> list=new ArrayList<>();
        int r = -1;
        for (int i=0;i<len;++i){
            if (set.contains(array[i])){
                continue;
            }
            list.add(array[i]);
            set.add(array[i]);
        }

        sb=new StringBuilder();
        for (int i = 0; i <list.size() ; i++) {
            sb.append(list.get(i));
        }

        System.out.println(Integer.parseInt(sb.toString()));


    }
}
