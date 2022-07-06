package codetop.HUAWEI;

/**
 * @ClassName leetcode120
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/4 16:24
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 */
public class leetcode120 {
    /**
     *动态规划:
     * dp[i][j]:代表到i，j位置的最小路径和
     *
     * dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;++i){
            //三角形左边开始的元素
            dp[i][0]=triangle.get(i).get(0)+dp[i-1][0];
            for (int j=1;j<i;++j){
                //三角形中间的元素
                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
            //三角形右边的元素
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int ans=dp[n-1][0];
        for (int i=1;i<n;++i){
            ans=Math.min(dp[n-1][i],ans);
        }

        return ans;

    }

    @Test
    public void test(){
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3,4)));
        list.add(new ArrayList<>(Arrays.asList(6,5,7)));
        list.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        int minimumTotal = minimumTotal(list);
        System.out.println(minimumTotal);
    }
}
