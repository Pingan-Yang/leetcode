package hot100;

/**
 * @ClassName leetcode14
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/11 11:11
 * @Version:1.0
 */

import org.junit.Test;

import javax.swing.*;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 */
public class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }


        int minIndex=0;
        int minlen=Integer.MAX_VALUE;
        int n=strs.length;
        for(int i=0;i<n;++i){
            if(strs[i].length()<minlen){
                minlen=strs[i].length();
                minIndex=i;
            }
        }
        String minString=strs[minIndex];
        minlen=minString.length();
        String ans="";
        for(int i=minlen;i>0;--i){
            String subString=minString.substring(0,i);
            boolean flag=true;
            for (int j=0;j<n;++j){
                if (j==minIndex){
                    continue;
                }
                if (!subString.equals(strs[j].substring(0, i))){
                    flag=false;
                    break;
                }
            }
            if (flag==true){
                ans=subString;
                break;
            }
        }
        return ans;
    }

    @Test
    public  void test(){
        String[] strs={"flower","flow","flight"};
       // String[] strs={"ab","a"};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
