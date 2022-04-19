package hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName leetcode128
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/3 21:39
 * @Version:1.0
 */
public class leetcode128 {
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        int curlength = 1;
        for (int i = 0; i <= n; ++i) {
            if (i == 0 || i == n || nums[i] > nums[i - 1] + 1) {
                ans = Math.max(ans, curlength);
                curlength = 1;
            } else if (nums[i] == nums[i - 1] + 1) {
                curlength++;
            }
        }
        return ans;
    }



    // 使用hash表： x,...,x+y是的连续，无序再从x+1开始判断 ，需要从 x+y+2开始判断是否有前驱x+y+1
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=1;
        for (int num:nums){
            if (!set.contains(num-1)){
                int curlength=1;
                int curNum=num;
                //遍历后面是否连续
                while (set.contains(curNum+1)){
                    curNum+=1;
                    curlength++;
                }

                ans=Math.max(ans,curlength);
            }
        }
        return ans;

    }
    @Test
    public void test() {
        // int[] nums={0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1, 2, 0, 1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
}
