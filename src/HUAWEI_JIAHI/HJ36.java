package HUAWEI_JIAHI;

/**
 * @ClassName HJ36
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/3 16:17
 * @Version:1.0
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。
 * 下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
 * 如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，
 * 并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y (实际需建立小写字母的字母表，此字母表仅为方便演示）
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，
 * 并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
 * 因此，使用这个密匙， Attack AT DAWN (黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * 数据范围：1≤n≤100  ，保证输入的字符串中仅包含小写字母
 *
 * 输入描述：
 * 先输入key和要加密的字符串
 *
 * nihao
 * ni
 *
 * le
 *
 * 输出描述：
 * 返回加密后的字符串
 */
public class HJ36 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String key=sc.nextLine();
            String encode=sc.nextLine();
            String res=process(key,encode);
            System.out.println(res);
        }
    }

    private static String process(String key, String encode) {
        //完成新的字母表
        char[] keyArrays = key.toCharArray();
        Set<Character> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for (char c:keyArrays){
            if (!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }
        for (int i=0;i<26;++i){
            char c=(char)('a'+i);
            if (!set.contains(c)){
                sb.append(c);
            }
        }
       // System.out.println(sb.toString());
        //开始加密

        StringBuilder res=new StringBuilder();
        char[] encodeArrays = encode.toCharArray();
        for (char ch:encodeArrays){
            int index=ch-'a';
            res.append(sb.charAt(index));
        }

        return res.toString();
    }

    @Test
    public void test(){
        String key="nihao";
        String encode="ni";
        process(key, encode);
    }

}
