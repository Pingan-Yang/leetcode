package codetop.HUAWEI;

/**
 * @ClassName leetcode03
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 19:43
 * @Version:1.0
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 */
public class leetcode03 {
    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        //左指针指滑动窗口左边界，右指针初始指向左指针的左边
        int left=0;
        int right=-1;
        Set<Character> set=new HashSet<>();
        char[] array = s.toCharArray();
        int ans=0;
        for (;left<n;++left){

            if (left!=0){
                //每次从下一左指针开始需要删除上一个开始的左边界的值
                set.remove(array[left-1]);
            }
            //每次都从左指针向后找，直到找到一个相同的，或者到末尾
            while(right+1<n&&!set.contains(array[right+1])){
                set.add(array[right+1]);
                right++;
            }
            ans=Math.max(ans,right-left+1);

        }

        return ans;
    }


    public static void main(String[] args) {
        test11();
    }
    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static  int test11(){
        int a=1;
        try {
            a=2;
            return a;
        }catch (Exception e){
            a=3;
            return a;
        }finally {
            a=4;
            System.out.println("1211"+a);
        }
    }
}














 