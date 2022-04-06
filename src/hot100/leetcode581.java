package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode581
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/26 19:31
 * @Version:1.0
 */
public class leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums==null||nums.length==0||nums.length==1){
            return 0;
        }
        // 双指针
        int n=nums.length;
        int min=nums[n-1];
        int max=nums[0];
        int begin=0,end=-1;
        for (int i=0;i<n;++i){
            if (nums[i]<max){ //从左到右维持最大值，寻找右边界end
                end=i;
            }else{
                max=nums[i];
            }

            if (nums[n-1-i]>min){ //从右到左维持最小值，寻找左边界begin
                begin=n-1-i;
            }else {
                min=nums[n-1-i];
            }
        }
        return end-begin+1;
    }

    @Test
    public void test(){
        int[] nums={ 2,6,4,8,10,9,15};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }
}
