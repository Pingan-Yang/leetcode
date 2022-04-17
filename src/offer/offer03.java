package offer;

import sun.security.util.Length;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName offer03
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 20:20
 * @Version:1.0
 */
public class offer03 {
    public int findRepeatNumber1(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;++i){
            if (set.contains(nums[i])){
                return  nums[i];
            }
            set.add(nums[i]);
        }

        return -1;

    }
    // 原地交换
    public int findRepeatNumber(int[] nums) {
        int index=0;
        int n=nums.length;
        while (index< n){
            if (nums[index]==index){
                index++;
                continue;
            }else if (nums[nums[index]]==nums[index]){
                return nums[index];
            }else{
                swap(nums,index,nums[index]);
            }
        }
        return -1;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
