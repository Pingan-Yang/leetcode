package HUAWEI_JIAHI;

/**
 * @ClassName HJ63
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/8 20:02
 * @Version:1.0
 */

import java.util.Scanner;

/**
 *  DNA序列
 *
 *  一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。
 *  G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 *  在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 *
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，
 * 请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 *
 *  数据范围：字符串长度满足 1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 *
 *
 *  输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 *
 * AACTGTGCACGACCTGA
 * 5
 *
 * GCACG
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 *
 *
 */
public class HJ63 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            int n=sc.nextInt();
            String ans=process2(s,n);
            System.out.println(ans);
        }
    }


    /**
     *滑动窗口：
     * 通过左右指针维护一个滑动窗口
     * 每次右指针右移，并判断字符，更新状态变量
     * 窗口缩小时，left左指针右移，同时更新count状态变量
     */
    private static String process2(String str, int n) {
        int left = 0, right = 0;
        int start = 0, count = 0, max = 0;
        while(right < str.length()) {
            char c = str.charAt(right++);
            if(c == 'C' || c == 'G') {
                count++;
            }
            if(count > max){
                max = count;
                start = left;
                // 剪枝
                if(count == n) {
                    return str.substring(start, start + n);
                }
            }
            // 窗口缩小
            if(right - left >= n) {
                char d = str.charAt(left++);
                if(d == 'C' || d == 'G') {
                    count--;
                }
            }
        }
        return str.substring(start, start + n);
    }

    //统计遍历
    private static String process(String s, int n) {
        String ans="";
        int len=s.length();
        int maxCount=0;
        for (int i=0;i<=len-n;++i){
            int count=0;
            for (int j=i;j<i+n;++j){
                if (s.charAt(j)=='G'||s.charAt(j)=='C'){
                    count++;
                }
            }
            if (maxCount<count){
                ans=s.substring(i, i+n);
                maxCount=count;
            }
        }
        return ans;
    }
}
