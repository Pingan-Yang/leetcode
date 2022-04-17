package offer;

import org.junit.Test;

/**
 * @ClassName offer53I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 20:33
 * @Version:1.0
 */
public class offer53I {
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (target==nums[mid]){
                int l1=mid;
                while (l1>=0&&nums[l1]==target){
                    l1--;
                }
                l1++;
                int r1=mid;
                while (r1<nums.length&&nums[r1]==target){
                    r1++;
                }
                r1--;
                return r1-l1+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[] nums={2,2};
        int search = search(nums, 3);
        System.out.println(search);
    }
}
