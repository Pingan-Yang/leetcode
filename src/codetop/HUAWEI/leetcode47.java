package codetop.HUAWEI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName leetcode47
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/16 22:01
 * @Version:1.0
 */

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class leetcode47 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    HashSet<List<Integer>> set=new HashSet<>();
    boolean[] isVisited;
    public List<List<Integer>> permuteUnique1(int[] nums) {
        int n=nums.length;
        isVisited=new boolean[n];
        dfs(nums,n,0);
        return res;
    }

    private void dfs(int[] nums, int n, int deepth) {
        if (deepth==n){
            if (!set.contains(list)){
                res.add(new ArrayList<>(list));
                set.add(list);
                return;
            }
        }


        for (int i=0;i<n;++i){
            if (!isVisited[i]){
                isVisited[i]=true;
                list.add(nums[i]);
                dfs(nums, n,deepth+1);
                isVisited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }

    //优化
    public List<List<Integer>> permuteUnique(int[] nums){
        int n=nums.length;
        isVisited=new boolean[n];
        //对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
        Arrays.sort(nums);
        backTrack(nums,n,0);
        return res;
    }

    private void backTrack(int[] nums, int n, int deepth) {
        if (deepth==n){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<n;++i){
            if (isVisited[i]||((i>0&&nums[i]==nums[i-1])&&!isVisited[i-1])){
                continue;
            }
            list.add(nums[i]);
            isVisited[i]=true;
            backTrack(nums,n,deepth+1);
            isVisited[i]=false;
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[] nums={1,1,2};
        List<List<Integer>> ans = permuteUnique(nums);
        System.out.println(ans);

    }
}
