package codetop.HUAWEI;

/**
 * @ClassName leetcode20
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 14:55
 * @Version:1.0
 */

import org.junit.Test;

import java.util.LinkedList;

/**
 * 20.有效的括号
 */
public class leetcode20 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < len; ++i) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
            } else {
                if ((stack.peek()=='('&&array[i]==')')||(stack.peek()=='{'&&array[i]=='}')||(stack.peek()=='['&&array[i]==']')){
                    stack.pop();
                }else{
                    stack.push(array[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s="{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
