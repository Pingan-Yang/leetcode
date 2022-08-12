package HUAWEI_JIAHI;

/**
 * @ClassName HJ27
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/2 19:51
 * @Version:1.0
 */

import org.junit.Test;

import java.util.*;

/**
 * 描述:
 *  定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 *
 * 输入描述：
 * 输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
 *
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 */
public class HJ27 {
    static List<String>list=new ArrayList<>();
    static StringBuilder sb=new StringBuilder();
    static boolean[] isVisited;
    public static void main(String[] args) {
        //处理输入
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String[] strs=new String[n];
            for (int i=0;i<n;++i){
                strs[i]=sc.next();
            }
            String dest=sc.next();
            isVisited=new boolean[dest.length()];
            int k=sc.nextInt();
            char[] chars = dest.toCharArray();
            Arrays.sort(chars);
            // 找到dest的所有兄弟单词
            findBrother(chars);
            //删除本身自己
            list.remove(dest);
            List<String> res=new ArrayList<>();
            for (String s:strs) {
                if (list.contains(s)){
                    res.add(s);
                }
            }
            //字符串按照字典序排序
            Collections.sort(res, (o1,o2) -> (o1 + o2).compareTo((o2 + o1)));
            System.out.println(res.size());
            if (k>=0&&k<res.size()){
                System.out.println(res.get(k-1));
            }
        }
    }

    //dfs:查找兄各字符串--其实就是带重复字母的全排序
    private static void findBrother(char[] chars) {
        if (sb.length()==chars.length){
            list.add(sb.toString());
            return;

        }
        for (int i=0;i<chars.length;++i){
            //过滤掉重复
            if (isVisited[i]||(i>0&&chars[i-1]==chars[i]&&!isVisited[i-1])){
                continue;
            }
            sb.append(chars[i]);
            isVisited[i]=true;
            findBrother(chars);
            isVisited[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    @Test
    public void test(){
        String s=new String("abc");
        findBrother(s.toCharArray());
        list.remove(s);
        System.out.println(list);
    }
}
