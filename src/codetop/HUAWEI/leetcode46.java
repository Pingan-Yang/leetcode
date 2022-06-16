package codetop.HUAWEI;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode46
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 21:41
 * @Version:1.0
 */

/**
 * leetcode46:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class leetcode46 {
    /**
     * dfs
     */
    List<List<Integer>> res;
    List<Integer> list;
    boolean[] isvisted;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        int n = nums.length;
        isvisted = new boolean[n];
        dfs(nums,n);
        return res;
    }

    private void dfs(int[] nums, int n) {
        if (list.size()== n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n ; ++i) {

            if (!isvisted[i]) {
                list.add(nums[i]);
                isvisted[i]=true;
//                System.out.println(list);
//                System.out.println("-------------------");
                dfs(nums,n);
                isvisted[i]=false;
                list.remove(list.size()-1);
            }
        }
    }

    @Test
    public void test(){
        int[] nums={1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
