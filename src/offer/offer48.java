package offer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @ClassName offer48
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 10:26
 * @Version:1.0
 */
public class offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int ans=0;
        int r=-1;
        HashSet<Character> set=new HashSet<>();
        for (int l=0;l<chars.length;++l){
            if (l!=0){//左指针右移---只要set中包含右指针的字符，就一直右移左指针，直到不包含
                set.remove(chars[l-1]);
            }
            while (r+1<chars.length&&!set.contains(chars[r+1])){//只要set中没有重复重复字符，右指针就不断右移
                set.add(chars[r+1]);
                r++;
            }
            ans=Math.max(r-l+1,ans);
        }
        return ans;
    }

    @Test
    public void test(){
        String s="abccabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("length:"+length);
    }
}
