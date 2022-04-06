package hot100;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName leetcode560
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/24 21:33
 * @Version:1.0
 */
public class leetcode560 {
    public int subarraySum(int[] nums, int k) {

        int count=0;
        int n=nums.length;
        int pre=0;
        HashMap<Integer,Integer> map=new HashMap<>();// 前缀和为key，出现的次数次数为value
        map.put(0,1);
        for (int i=0;i<n;++i){
            pre+=nums[i];
            if (map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }
}
