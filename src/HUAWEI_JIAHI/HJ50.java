package HUAWEI_JIAHI;

/**
 * @ClassName HJ50
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/4 16:57
 * @Version:1.0
 */


import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足 ∣val∣≤1000  ，字符串长度满足 1000 \1≤n≤1000
 *
 * 输入一个算术表达式
 *
 * 得到计算结果
 *
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 25
 */
public class HJ50 {

    /**
     * 逆波兰计算器(后缀表达式)的计算过程为：
     *      从左到右扫描后缀表达式，遇到数字就入栈，遇到操作符就从栈弹出两个数字，然后计算得到的值继续入栈，继续扫描表达式，
     *      直到扫描完毕得到结果。
     *
     * 如何把中缀表达式转成后缀表达式？
     *   1、初始化两个栈：运算符栈s1和存储中间结果的栈s2；
     *
     *   2、从左到右扫描中缀表达式；
     *
     *   3、遇到操作数时，压入到栈s2；
     *
     *   4、遇到运算符时：
     *
     *     1）如果s1为空或s1栈顶为左括号"("，则压入到s1；
     *
     *     2）不满足1），则和s1栈顶运算符比较优先级，高于，则压入s1；
     *
     *     3）不满足1）和2），弹出s1栈顶运算符并压入到s2，再次回到2）。
     *
     *   5、遇到右括号")“时，依此弹出s1并压入s2，直到遇到左括号”)"为止，此时丢掉一对括号；
     *
     *   6、重复2-5，直到扫描完毕；
     *
     *   7、将s2栈弹出压入到s1，然后s1弹出全部，弹出的顺序即为后缀表达式。
     */
    public static void main(String[] args) throws ScriptException {
        //奇淫技巧
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        input = input.replace("[","(");
//        input = input.replace("{","(");
//        input = input.replace("}",")");
//        input = input.replace("]",")");
//        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
//        System.out.println(scriptEngine.eval(input));



        //逆波兰表达式
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<String> infix = expressionToList(s);  // List
        List<String> suffix = infixToSuffix(infix); // 中缀转后缀
        Stack<String> stk = new Stack<>();    // 存储中间结果
        // 逆波兰计算器
        for (int i = 0; i < suffix.size(); i++) {
            String tmp = suffix.get(i);
            if (isOper(tmp)) {
                String num2 = stk.pop();
                String num1 = stk.pop();
                String reuslt = cal(num1, tmp, num2);
                stk.push(reuslt);
            } else { // 数字直接入栈
                stk.push(tmp);
            }
        }
        System.out.println(stk.pop());
    }
    public static String cal(String num1, String oper, String num2) {
        Long result = 0l;
        Long a = Long.parseLong(num1);
        Long b = Long.parseLong(num2);
        switch (oper) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        return String.valueOf(result);
    }


    /**
     *中缀转后缀
     *  1、初始化两个栈：运算符栈s1和存储中间结果的栈s2；
     *  2、从左到右扫描中缀表达式；
     *  3、遇到操作数时，压入到栈s2；
     *  4、遇到运算符时：
     *    1）如果s1为空或s1栈顶为左括号"("，则压入到s1；
     *    2）不满足1），则和s1栈顶运算符比较优先级，高于，则压入s1；
     *    3）不满足1）和2），弹出s1栈顶运算符并压入到s2，再次回到2）。
     *  5、遇到右括号")“时，依此弹出s1并压入s2，直到遇到左括号”)"为止，此时丢掉一对括号；
     *  6、重复2-5，直到扫描完毕；
     *  7、将s2栈弹出压入到s1，然后s1弹出全部，弹出的顺序即为后缀表达式。
     */
    public static List<String> infixToSuffix(List<String> infix) {
        List<String> suffix = new ArrayList<>();
        Stack<String> stack1 = new Stack<>();   // 只用于保存操作符
        Stack<String> stack2 = new Stack<>();   // 用于保存中间结果
        for (int i = 0; i < infix.size(); i++) {
            String tmp = infix.get(i);
            if (isOper(tmp)) {   // 操作符要根据情况来入栈 1
                if (stack1.isEmpty() || "(".equals(tmp) || "[".equals(tmp) || "{".equals(tmp)) {
                    // 如果 stack1 是空的，或者 tmp 是左括号，直接入栈
                    stack1.push(tmp);
                } else { // stack1 不是空的，且 tmp 不是左括号
                    if (")".equals(tmp) || "]".equals(tmp) || "}".equals(tmp)) {
                        // tmp 是右括号，则把 stack1 遇到左括号之前，全部倒入 stack2
                        while (!("(".equals(stack1.peek()) || "[".equals(stack1.peek()) || "{".equals(stack1.peek()))) {
                            stack2.push(stack1.pop());
                        }
                        stack1.pop();   // 丢掉左括号
                    } else {
                        // tmp 是 +-*/ 其中之一
                        while (!stack1.isEmpty() && priority(stack1.peek()) >= priority(tmp)) {
                            // 在 tmp 能够碾压 stack1 的栈顶操作符之前，把 stack1 的栈顶操作符倒入 stack 2 中
                            stack2.push(stack1.pop());
                        }
                        // 离开 while 时，要么 stack1 已经倒空了，要么就是现在 tmp 可以压住 stack.peek() 了
                        stack1.push(tmp);
                    }
                }
            } else { // 操作数直接入栈 2
                stack2.push(tmp);
            }
        }

        // stack1 剩余操作符全部倒入 stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // stack2 的逆序才是结果，所以要再倒一次
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // 现在 stack1 的元素倒出来的顺序就是后缀表达式
        while (!stack1.isEmpty()) {
            suffix.add(stack1.pop());
        }

        return suffix;
    }

    /**
     *将字符串中的数字和运算符分开
     */
    public static List<String> expressionToList(String expression) {
        List<String> list = new ArrayList<>();
        int len = expression.length();
        String keepNum = "";
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                if (i != len - 1 && Character.isDigit(expression.charAt(i + 1))) {
                    // 如果下一个字符也是数字
                    keepNum += c;
                } else {
                    // 当前是最后一个字符，或者下一个开始不是数字
                    keepNum += c;
                    list.add(keepNum);
                    keepNum = "";
                }
            }else if(c == '-'){
                if(i==0 || expression.charAt(i-1)=='(' || expression.charAt(i-1)=='[' || expression.charAt(i-1)=='{'){
                    keepNum += c;
                }else{
                    list.add(c + "");
                }
            }else{
                list.add(c + "");
            }
        }
        return list;
    }

    public static boolean isOper(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str) ||
                "(".equals(str) || ")".equals(str) || "[".equals(str) || "]".equals(str) ||
                "{".equals(str) || "}".equals(str);
    }

    public static int priority(String oper) {
        if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else {
            return -1;
        }
    }
}
