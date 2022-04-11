package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode75
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/11 20:06
 * @Version:1.0
 */
public class leetcode75 {
    public void sortColors(int[] nums) {
        //快排的思想
        // 定义两个指针l,r;l指向<1的末尾 r指向大于1的开头
        // 初始时l=-1 r=nums.length
        // 若 nums[i]<1 交换nums[i]和l边界的下一个数  i++;l++
        // 若 nums[i]==1 i++
        // 若 nums[i]>1  交换nums[i]和r边界的上一个数 r--; i不可以++因为不能确定换过来的数是否=1

        int n=nums.length;
        int l=-1,r=n;
        int i=0;
        while (i<r){
            if (nums[i]<1){
                swap(nums,i++,++l);
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums,i,--r);
            }
        }
     }
     private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
     }

     @Test
    public void test(){
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
         System.out.println(Arrays.toString(nums));
     }
}
