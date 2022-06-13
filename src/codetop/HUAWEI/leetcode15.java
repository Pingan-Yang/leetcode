package codetop.HUAWEI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode15
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 20:28
 * @Version:1.0
 */

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        //将数组排序
        Arrays.sort(nums);

        if (nums[0] + nums[1] + nums[2] > 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i >0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int num1 = nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -num1) {
                    ans.add(Arrays.asList(num1, nums[l], nums[r]));
                    int l1 = l;
                    l++;
                    while (l < r && nums[l1] == nums[l]) {
                        l++;
                    }
                    int r1 = r;
                    r--;
                    while (l<r && nums[r1] == nums[r]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] > -num1) {
                    int r1 = r ;
                    r--;
                    while (l < r && nums[r1] == nums[r]) {
                        r--;
                    }
                }else{
                    int l1 = l;
                    l++;
                    while (l < r && nums[l1] == nums[l]) {
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
}
