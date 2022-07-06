package codetop.HUAWEI;

/**
 * @ClassName leetcode560
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/6 21:03
 * @Version:1.0
 */

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class leetcode560 {
    //暴力法
    //执行用时：1737 ms, 在所有 Java 提交中击败了5.50%的用户
    //内存消耗：45 MB, 在所有 Java 提交中击败了24.40%的用户
    public int subarraySum1(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        for (int end=0;end<n;++end){
            int sum=0;
            for (int start=end;start>=0;start--){
                sum+=nums[start];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *利用 hash表记录前缀和
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();//K:前缀和，V：前缀和出现的次数
        map.put(0,1);//这一行的作用就是为了应对 nums[0] +nums[1] + ... + nums[i] == k 的情况的
        int prevSum=0;
        int n=nums.length;
        int count=0;
        for (int i=0;i<n;++i){
            prevSum+=nums[i];
            if (map.containsKey(prevSum-k)){
                count+=map.get(prevSum-k);
            }
            map.put(prevSum,map.getOrDefault(prevSum, 0)+1);
        }
        return count;
    }
}
