package hot100;

import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

/**
 * @ClassName leetcode46
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/7 21:32
 * @Version:1.0
 */
public class leetcode46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;//用于记录start位置的数 是否被用过

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            path.add(nums[0]);
            res.add(new ArrayList<Integer>(path));
            return res;
        }
        used=new boolean[nums.length];
        dfs(nums,0);
        return res;
    }
    // depth：代表全排列的长度
    private void dfs(int[] nums,int depth){
        if (depth==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if(!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, depth + 1);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    @Test
    public void test(){
        int[] nums={1,2,3,4};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
