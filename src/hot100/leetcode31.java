package hot100;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

/**
 * @ClassName leetcode31
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/6 22:21
 * @Version:1.0
 */
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        // 1 2 3 4 5
        // 1 2 3 5 4
        // 1 2 4 3 5
        // 1 2 4 5 3
        // 1 2 5 4 3
        // 1 2 5 3 4
        // ...
        // 5 4 3 2 1
        int n = nums.length;
        if (n < 2) {
            return;
        }
        for (int i=n-1;i>0;i--){
            if (nums[i-1]<nums[i]){
                //对找到需要替换的数的后面的序列作升序
                Arrays.sort(nums,i,n);
                //从后面的序列找一个大于nums[i]&&最接近于nums[i-1]的数
                for (int j=i;j<n;j++){
                    if(nums[j]>nums[i-1]){
                        swap(nums,i-1,j);
                        return;
                    }
                }
            }
        }
        //如果倒叙遍历一圈都没有找到前面一个数比后面一个数小的，则证明是逆序
        Arrays.sort(nums);

    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    @Test
    public void test(){
        int[] nums={1,2,3,5,4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
