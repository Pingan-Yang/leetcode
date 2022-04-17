package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName offer50
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 22:19
 * @Version:1.0
 */
public class offer50 {
    public char firstUniqChar(String s) {
        if (s==null||s.length()==0){
            return ' ';
        }
        //用于记录只重复的字母
        Set<Character> set=new HashSet<>();
        //用于记录只出现一次的字母
        List<Character>res=new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (!set.contains(c)){
                set.add(c);
                res.add(c);
            }else{
                res.remove(new Character(c));
            }

        }
        return res.size()==0?' ':res.get(0);
    }

    @Test
    public void test(){
        String s="abaccdeff";
        char c = firstUniqChar(s);
        System.out.println("c:"+c);
    }
}
