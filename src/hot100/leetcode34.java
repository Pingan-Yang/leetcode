package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode34
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/7 20:29
 * @Version:1.0
 */
public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] rang={-1,-1};
        if (nums==null||nums.length==0){
            return rang;
        }
        int n=nums.length;
        if (target<nums[0]||target>nums[n-1]){
            return rang;
        }

        int l=0;
        int r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==target){
                rang[0]=mid-1;
                rang[1]=mid+1;
                while (rang[0]>=0&&nums[rang[0]]==target){
                    rang[0]--;
                }
                rang[0]++;
                while (rang[1]<n&&nums[rang[1]]==target){
                    rang[1]++;
                }
                rang[1]--;
                return rang;
            }else if(target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return rang;
    }

    @Test
    public void test(){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] range = searchRange(nums, target);
        System.out.println(Arrays.toString(range));
    }
}
