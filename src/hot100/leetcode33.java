package hot100;

import org.junit.Test;


/**
 * @ClassName leetcode33
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/7 20:11
 * @Version:1.0
 */
public class leetcode33 {
    public int search(int[] nums, int target) {
        if (nums.length==1){
            if (target==nums[0]){
                return 0;
            }else{
                return -1;
            }
        }

        // 使用二分查找
        // 找出两段数组的分界点
        int n=nums.length;
        int index=0;
        for(int i=0;i<n-1;++i){
            if (nums[i+1]<nums[i]){
                index=i+1;
            }
        }
        if (index==0){
            if (target<nums[0]||target>nums[n-1]){
                return -1;
            }else{
                return binarySearch(nums,0,n-1, target);
            }
        }else{
            if (target>=nums[0]){
                return binarySearch(nums,0,index-1, target);
            }else{
                return binarySearch(nums,index,n-1,target);
            }
        }
    }
    private int binarySearch(int[] nums,int left,int right,int target){
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    @Test
    public void  test(){
        int[] nums={4,5,6,7,0,1,2};
        int index = search(nums, 0);
        System.out.println("index="+index);
    }
}
