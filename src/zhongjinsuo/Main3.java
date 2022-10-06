package zhongjinsuo;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans= firstUniqChar(s);
        System.out.println(ans);

    }

    public static int  firstUniqChar(String s) {
        if (s==null||s.length()==0){
            return -1;
        }
        Set<Character> set=new HashSet<>();
        List<Character> res=new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (!set.contains(c)){
                set.add(c);
                res.add(c);
            }else{
                res.remove(new Character(c));
            }

        }
        return res.size()==0?-1:s.indexOf(res.get(0));
    }
}
