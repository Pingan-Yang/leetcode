package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode128
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/3 21:39
 * @Version:1.0
 */
public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        int ans=1;
        int maxLength=1;
        int n=nums.length;
        for (int i=1;i<n;++i){
            if(nums[i-1]+1==nums[i]){
                maxLength++;
            }else{
                ans=Math.max(ans,maxLength);
                maxLength=1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
}
