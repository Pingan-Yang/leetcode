package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode169
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 21:42
 * @Version:1.0
 */
public class leetcode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;++i){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
                continue;
            }
            map.put(nums[i],map.get(nums[i])+1);
        }

        int result=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>nums.length/2){
                result=entry.getKey();
            }
        }
        return result;
    }
}
