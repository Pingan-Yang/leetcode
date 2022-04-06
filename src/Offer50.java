import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Offer50
 * @Description: TODO
 * @Author 15368
 * @Date 2022/1/19 21:59
 * @Version:1.0
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if (s==null||s.length()==0){
            return ' ';
        }
        Set<Character> set=new HashSet<>();
        ArrayList<Character> list=new ArrayList<>();
        char[] chs=s.toCharArray();
        for (int i=0;i<chs.length;++i){
            if (!set.contains(chs[i])){
                set.add(chs[i]);
                list.add(chs[i]);
            }else{
                Character c=chs[i];
                list.remove(c);
            }
        }
        return list.isEmpty()?' ':list.get(0);
    }
    @Test
    public void test(){
        String s="loveleetcode";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
}
