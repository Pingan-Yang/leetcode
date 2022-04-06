package hot100;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName leetcode17
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/31 20:19
 * @Version:1.0
 */
public class leetcode17 {
    Map<Character,String> map= new  HashMap();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res=new ArrayList<>();
        if (digits==null||digits.length()==0){
            return res;
        }
        backTrack(digits,0,res,new StringBuilder());
        return res;
    }
    private void backTrack(String digits,int index,List<String> res,StringBuilder str){
        //回溯的返回条件
        if (digits.length()==str.length()){
            res.add(str.toString());
            return;
        }
        char[]chars=map.get(digits.charAt(index)).toCharArray();
        for (int i=0;i<chars.length;++i){
            str.append(chars[i]);
            backTrack(digits,index+1, res,str);
            str.deleteCharAt(index);
        }
    }
    @Test
    public void test(){
        String s="23";
        List<String> list = letterCombinations(s);
        System.out.println(list);
    }
}
