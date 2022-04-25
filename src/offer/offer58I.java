package offer;

import org.junit.Test;

/**
 * @ClassName offer58I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 20:06
 * @Version:1.0
 */
public class offer58I {
    public String reverseWords(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        s=s.trim();// 删除首尾空格
        int j=s.length()-1;
        int i=j;
        StringBuilder res=new StringBuilder();
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;// 搜索首个空格
            res.append(s.substring(i+1,j+1)+" ");// 添加单词
            while (i>=0&&s.charAt(i)==' ') i--;//记录中间的空格数
          //  res.append(s.substring(i+1,j));//添加空格
            j=i;// j 指向下个单词的尾字符
        }

        return res.toString().trim();
    }

    @Test
    public void test(){
        String s="a good   example";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
