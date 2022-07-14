package codetop.HUAWEI;

/**
 * @ClassName leetcode525
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/7 14:47
 * @Version:1.0
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class leetcode525 {
    /**
     * 前缀和+哈希表
     * 问题转换：找到含有相同数量的 0 和 1 的最长连续子数组===>将nums[i]=0替换成nums[i]=-1===>变成了如何求得最长一段区间和为 0 的子数组。
     * <p>
     * 步骤：
     * 再求前缀和的时候将 nums[i] 为 0 的值当做 −1 处理。
     * 同时使用「哈希表」来记录「某个前缀和出现的最小下标」是多少。
     */
    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];//前缀和数组
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //如果答案非 0，子数组长度至少为 2,循环从 2 开始。
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(sum[i - 2])) {
                map.put(sum[i - 2], i - 2);
            }
            if (map.containsKey(sum[i])) {
                ans = Math.max(ans, i - map.get(sum[i]));
            }
        }
        return ans;
    }

//    public int findMaxLength(int[] nums) {
//        int n=nums.length;
//        int[] sum=new int[n];
//        sum[0]=nums[0]==1?1:-1;
//        for (int i=1;i<n;++i){
//            sum[i]=sum[i-1]+(nums[i]==1?1:-1);
//        }
//        int ans=0;
//        for ()
//    }

    @Test
    public void test(){
        int[] nums={0,1,0};
        int maxLength = findMaxLength1(nums);
        System.out.println(maxLength);
    }
}
