package offer;

import org.junit.Test;

/**
 * @ClassName offer20
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 10:29
 * @Version:1.0
 */
public class offer20 {
    public boolean isNumber(String s) {
        //数值举例：["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
        //非数值举例：["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]

        // 分不同情况 判断即可
        if (s == null || s.length() == 0) {
            return false;
        }
        // 定义标志位
        boolean isNum = false;
        boolean isDot = false;
        boolean iseOrE = false;

        char[] array = s.trim().toCharArray();//去除前后空格
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            if (array[i] >= '0' && array[i] <= '9') {//判断当前字符是否是数字
                isNum = true;
            } else if (array[i] == '.') {//判断当前字符是否是小数点
                if (isDot || iseOrE) {//小数点之前还有小数点或者出现了 e E
                    return false;
                }
                isDot = true;
            } else if (array[i] == 'e' || array[i] == 'E') {//判断当前字符是否是e E
                if (!isNum || iseOrE) {//e之前没有数字或者已经出现了e
                    return false;
                }
                iseOrE = true;
                isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            } else if (array[i] == '+' || array[i] == '-') {// 判断当前符号是否是正负号
                if (i != 0 && array[i - 1] != 'e' && array[i - 1] != 'E') {// 判断正负号是否是否出现在第一位或者e之后
                    return false;
                }
            } else {
                return false; // 其它情况均为不合法字符
            }
        }

        return isNum;
    }

    @Test
    public void test() {
        String s = " -1.8E-16 ";
        boolean number = isNumber(s);
        System.out.println(number);
    }
}
