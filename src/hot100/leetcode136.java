package hot100;

/**
 * @ClassName leetcode136
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/19 21:13
 * @Version:1.0
 */
public class leetcode136 {
    public int singleNumber(int[] nums) {
        //异或运算
        int single=0;
        for (int i=0;i<nums.length;++i){
            single^=nums[i];
        }
        return single;
    }
}
