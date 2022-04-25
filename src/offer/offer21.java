package offer;

/**
 * @ClassName offer21
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 19:46
 * @Version:1.0
 */
public class offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int l = 0;
        int r=nums.length-1;
        while (l<=r){
            while (l<=r&&nums[l]%2!=0){
                l++;
            }
            while (l<=r&&nums[r]%2==0){
                r--;
            }
            if (l<=r){
                swap(nums,l,r);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
