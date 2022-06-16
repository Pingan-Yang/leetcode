package codetop.HUAWEI;

/**
 * @ClassName leetcode316
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 16:22
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode316:给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 要求一、要去重。
 *
 * 要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
 *
 * 要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。
 *
 */
public class leetcode316 {
    public String removeDuplicateLetters(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        //记录当前元素在不在栈中
        boolean[] isExistStack=new boolean[26];
        //记录每个字符的个数
        int[] count=new int[26];
        //存放满足题目条件的结果的栈
        Deque<Character> stack=new ArrayDeque<>();

        for (Character c:chars){
            //记录字符出现的次数
            count[c-'a']++;
        }

        for (Character c:chars){
            //每遍历一个字符，出现的次数-1
            count[c-'a']--;
            //如果当前的字符，存在在栈中  则跳过
            if (isExistStack[c-'a']) continue;

            //当前字符与依次与栈顶元素比较
            while (!stack.isEmpty()&&stack.peek()>c){
                //如果栈顶元素后续不再出现，则保留
                if (count[stack.peek()-'a']==0){
                    break;
                }
                //如果栈顶元素后续再出现，则出栈
                isExistStack[stack.pop()-'a']=false;
            }
            // 第一次直接插入，或者栈顶元素小于当前元素也插入
            stack.push(c);
            isExistStack[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    /**
     *完成要求一、二
     */
    public String OneAndTwo(String s){
        if (s==null||s.length()==0){
            return s;
        }
        //存放去重的set
        Deque<Character> stack=new ArrayDeque<>();
        //记录是否存在某个字符
        boolean[] isExist=new boolean[26];

        for (Character c:s.toCharArray()){
            //如果字符已经存在则跳过
            if (isExist[c-'a']){
                continue;
            }
            //如果不存在，则插入栈顶并标记为存在
            stack.push(c);
            isExist[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //栈中元素的插入顺序是反的，需要reverse一下
        return sb.reverse().toString();
    }

    /**
     * 完成要求三：需要做些什么修改？
     * 在向栈 stk 中插入字符 'a' 的这一刻，我们的算法需要知道，字符 'a' 的字典序和之前的两个字符 'b' 和 'c' 相比，谁大谁小？
     *
     * 如果当前字符 'a' 比之前的字符字典序小，就有可能需要把前面的字符 pop 出栈，让 'a' 排在前面，对吧
     *
     *
     */
    public String OneAndTwo2(String s){
        if (s==null||s.length()==0){
            return s;
        }
        //存放去重的set
        Deque<Character> stack=new ArrayDeque<>();
        //记录是否存在某个字符
        boolean[] isExist=new boolean[26];

        for (Character c:s.toCharArray()){
            //如果字符已经存在则跳过
            if (isExist[c-'a']){
                continue;
            }

            //插入之前，和之前的元素比一下大小
            //如果字典序比前面的小。pop()前面的元素
            while (!stack.isEmpty()&&stack.peek()>c){
                // 弹出栈顶元素，并把该元素标记为不在栈中
                Character top=stack.pop();
                isExist[top-'a']=false;

            }
            //插入栈顶并标记为存在
            stack.push(c);
            isExist[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //栈中元素的插入顺序是反的，需要reverse一下
        return sb.reverse().toString();
    }

    /**
     *上一般还是存在问题
     * 我们的算法在 stk.peek() > c 时才会 pop 元素，其实这时候应该分两种情况：
     * 情况一、如果 stk.peek() 这个字符之后还会出现，那么可以把它 pop 出去，反正后面还有嘛，后面再 push 到栈里，刚好符合字典序的要求。
     *
     * 情况二、如果 stk.peek() 这个字符之后不会出现了，前面也说了栈中不会存在重复的元素，那么就不能把它 pop 出去，否则你就永远失去了这个字符。
     *
     * 回到 s = "bcac" 的例子，插入字符 'a' 的时候，发现前面的字符 'c' 的字典序比 'a' 大，且在 'a' 之后还存在字符 'c'，那么栈顶的这个 'c' 就会被 pop 掉。
     *
     * while 循环继续判断，发现前面的字符 'b' 的字典序还是比 'a' 大，但是在 'a' 之后再没有字符 'b' 了，所以不应该把 'b' pop 出去。
     *
     * 那么关键就在于，如何让算法知道字符 'a' 之后有几个 'b' 有几个 'c' 呢？

     */
    public String OneAndTwo3(String s){
        if (s==null||s.length()==0){
            return s;
        }
        //存放去重的set
        Deque<Character> stack=new ArrayDeque<>();
        //记录是否存在某个字符
        boolean[] isExist=new boolean[26];

        //记录每个字符出现的次数
        int[] count=new int[26];
        for (Character c:s.toCharArray()){
            count[c-'a']++;
        }


        for (Character c:s.toCharArray()){

            //每遍历一次字符都将对应的字符的个数-1
            count[c-'a']--;

            //如果字符已经存在则跳过
            if (isExist[c-'a']){
                continue;
            }

            //插入之前，和之前的元素比一下大小
            //如果字典序比前面的小。pop()前面的元素
            while (!stack.isEmpty()&&stack.peek()>c){
                // 如果该元素后续不在出现，则保留
                if (count[stack.peek()-'a']==0){
                    break;
                }
                // 若之后还有，则可以 pop
                Character top=stack.pop();
                isExist[top-'a']=false;

            }
            //插入栈顶并标记为存在
            stack.push(c);
            isExist[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //栈中元素的插入顺序是反的，需要reverse一下
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        String s="bcabc";
       // String s1 = OneAndTwo3(s);
        String s1=removeDuplicateLetters(s);
        System.out.println(s1);
    }
}
