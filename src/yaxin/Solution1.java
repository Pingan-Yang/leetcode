package yaxin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution1 {
    public boolean testValid (String str) {
        // write code here
        int n=str.length();
        if (n%2!=0){
            return  false;
        }
        char[] chars = str.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        for (int i=0;i<n;++i){
            if (!stack.isEmpty()){
                if ((stack.peek()=='('&&chars[i]==')')||(stack.peek()=='{'&&chars[i]=='}')||(stack.peek()=='['&&chars[i]==']')){
                    stack.pop();
                }else{
                    stack.push(chars[i]);
                }

            }else{
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
