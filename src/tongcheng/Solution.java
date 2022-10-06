package tongcheng;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String longestPrefix (String s) {
        // write code here
        Deque<String> stack1=new ArrayDeque<>();
        Deque<String> stack2=new ArrayDeque<>();

        for (int i=1;i<=s.length()-1;++i){
            stack1.push(s.substring(0,i));
        }
        for (int i=s.length()-1;i>=1;--i){
            stack2.push(s.substring(i,s.length()));
        }
        String ans=null;
        while(!stack1.isEmpty()&&!stack2.isEmpty()) {
            String s1 = stack1.pop();
            String s2 = stack2.pop();
            if (s1.equals(s2)) {
                ans = s1;
                break;
            }
        }
        return ans;

    }

    @Test
    public void test(){
        String s="level";
        System.out.println(longestPrefix(s));
    }
}
