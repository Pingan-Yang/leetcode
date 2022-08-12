package HUAWEI_JIAHI;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @ClassName HJ20
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/23 14:40
 * @Version:1.0
 */
public class HJ20 {
}

/**
 * 密码要求:
 * <p>
 * 1.长度超过8位
 * <p>
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * <p>
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * <p>
 * 数据范围：输入的字符串长度满足 1≤n≤100
 * <p>
 * <p>
 * 输入描述：
 * 一组字符串。
 * <p>
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 */
class Main20 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            //判断长度
            if (str.length() < 8) {
                System.out.println("NG");
                continue;
            }
            //判断字符串是否有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
            if (containsRepeat3(str)) {
                System.out.println("NG");
                continue;
            }
            //判断字符串是否含有包括大小写字母.数字.其它符号,以上四种至少三种
            if (getMatch(str)) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }

    }

    //判断是否有相同长度大于2的子串重复,所以取长度为3的子串做比对
    public static boolean containsRepeat3(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            String sonString = s.substring(i, i + 3);
            int count = 0;//子串的个数，如果>1,则不满足要求
            for (int j = 0; j < s.length() - 2; j++) {
                if (s.charAt(j) == sonString.charAt(0) &&
                        s.charAt(j + 1) == sonString.charAt(1) &&
                        s.charAt(j + 2) == sonString.charAt(2)) {
                    count++;
                }
            }
            if (count > 1) {
                return true;//
            }
        }
        return false;
    }

    // 检查是否满足正则
    private static boolean getMatch(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void test() {

    }
}
