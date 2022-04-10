package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode39
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/7 20:44
 * @Version:1.0
 */
public class leetcode39 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
    private void dfs(int[] candidates,int index,int target){
        if(target==0){
            res.add(new ArrayList(list));
            return;
        }

        for(int i=index;i<candidates.length;++i){
            if(candidates[index]>target){
                return;
            }
            list.add(candidates[i]);
            dfs(candidates,i,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[] candidates={2,3,6,7};
        int target=7;
        List<List<Integer>> list = combinationSum(candidates, target);
        System.out.println(list);
    }
}
