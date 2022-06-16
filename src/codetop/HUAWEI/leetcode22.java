package codetop.HUAWEI;

/**
 * @ClassName leetcode22
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/16 22:28
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：
 *      数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class leetcode22 {
    List<String> res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0);
        return res;
    }

    private void dfs(int n,int lCount,int rCount) {

        //剪枝的条件：'('的个数大于n 或者‘)’的个数>'('

        if (lCount>n||lCount<rCount){
            return;
        }

        if (sb.length()==n*2){
            res.add(sb.toString());
            return;
        }

        //‘(’<n 表示还可以加‘(’
        if (lCount<n){
            sb.append("(");
            dfs(n,lCount+1,rCount);
            sb.deleteCharAt(sb.length()-1);
        }
        //‘)’ < '('表示还可以加‘)’
        if (rCount<lCount){
            sb.append(")");
            dfs(n,lCount,rCount+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    @Test
    public void test(){
        int n=3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }
}
