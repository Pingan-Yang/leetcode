package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode22
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/5 20:36
 * @Version:1.0
 */
public class leetcode22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        // dfs+剪枝
        dfs(n, 0, 0, new StringBuilder());

        return res;
    }

    private void dfs(int n, int leftCount, int rightCount, StringBuilder str) {
       //剪枝的条件：左括号的数量>n,或者右括号的数量>左括号
        if (leftCount > n || leftCount < rightCount) {
            return;
        }
        // 满足条件的答案
        if (str.length() == 2 * n) {
            res.add(str.toString());
            return;
        }
        // 如果‘（’<n 表明 还就可以加‘（’
        if (leftCount <n) {
            str.append("(");
            dfs(n, leftCount + 1, rightCount, str);
            str.deleteCharAt(str.length()-1);
        }
        // 如果‘(’>')' 表明 还就可以加‘)’
        if(leftCount>rightCount) {
            str.append(")");
            dfs(n, leftCount, rightCount + 1, str);
            str.deleteCharAt(str.length()-1);
        }
    }

    @Test
    public void test() {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
}
