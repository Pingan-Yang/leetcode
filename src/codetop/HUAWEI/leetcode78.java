package codetop.HUAWEI;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode78
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/16 22:40
 * @Version:1.0
 */

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class leetcode78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        int n = nums.length;
        dfs(nums, n, 0);

        return res;
    }

    private void dfs(int[] nums, int n, int start) {
        //dfs终止条件 如果走到了  最后一个索引  说明已经完成了
        if (start >= n) {
            return;
        }

        for (int i = start; i < n; ++i) {
            list.add(nums[i]);
            res.add(new ArrayList<Integer>(list));
            dfs(nums,n,i+1);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
}
