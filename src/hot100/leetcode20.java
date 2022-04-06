package hot100;

import org.junit.Test;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName leetcode20
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/5 20:01
 * @Version:1.0
 */
public class leetcode20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        int n = chars.length;
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                if (chars[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (chars[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (chars[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                }else{
                    stack.push(chars[i]);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        String s = "([}}])";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
