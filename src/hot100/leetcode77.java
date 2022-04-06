package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode77
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/1 17:20
 * @Version:1.0
 */
public class leetcode77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;

    }

    private void dfs(int n, int start, int k) {
        if (list.size() ==k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; ++i) {
            list.add(i);
            dfs(n,i+1,k);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void  test01(){
        /**
         * [
         *   [2,4],
         *   [3,4],
         *   [2,3],
         *   [1,2],
         *   [1,3],
         *   [1,4],
         * ]
         */
        List<List<Integer>> lists = combine(4, 2);
        for (List<Integer>list:lists){
            System.out.println(list);
        }
    }
}
