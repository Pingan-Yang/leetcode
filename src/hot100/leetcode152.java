package hot100;

/**
 * @ClassName leetcode152
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/26 21:34
 * @Version:1.0
 */
public class leetcode152 {
    public int maxProduct(int[] nums) {
        //这里不仅需要维护一个最大值的dp 也需要维护一个最小值的dp
        // 因为当前位置的最优解未必是由前一个位置的最优解转移而来
        int maxF=nums[0];
        int minF=nums[0];
        int ans=nums[0];
        for (int i=1;i<nums.length;++i){
            int mx=maxF;
            int mn=minF;
            maxF=Math.max(mx*nums[i],Math.max(mn*nums[i],nums[i]));
            minF=Math.min(mx*nums[i],Math.min(mn*nums[i],nums[i]));
            ans=Math.max(ans,maxF);
        }
        return ans;
    }
}
