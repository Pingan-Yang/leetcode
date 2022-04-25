package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName offer57
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 19:56
 * @Version:1.0
 */
public class offer57 {
    public int[] twoSum(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            if (nums[l]+nums[r]==target){
                return new int[]{nums[l],nums[r]};
            }else if (nums[l]+nums[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
