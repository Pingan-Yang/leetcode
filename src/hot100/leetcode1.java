package hot100;

import java.util.HashMap;

/**
 * @ClassName leetcode1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/29 10:28
 * @Version:1.0
 */
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
