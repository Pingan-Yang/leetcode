package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode78
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/1 16:33
 * @Version:1.0
 */
public class leetcode78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        dfs(nums,0);
        return res;
    }

    // start 每次开始的索引
    private void dfs(int[] nums,int start){
        if (start>=nums.length){
            // 如果走到了  最后一个索引  说明已经完成了
            return;
        }
        for (int i=start;i<nums.length;++i){
            list.add(nums[i]);
            //一定要new一个ArrayList<>() 不然是一堆空集
            res.add(new ArrayList<>(list));
            dfs(nums,i+1);
            // 回溯，把上一次加的元素给剔除掉
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[] nums={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> list:subsets){
            System.out.println(list);
        }
    }
}
