package codetop.HUAWEI;

/**
 * @ClassName leetcode18
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/14 19:30
 * @Version:1.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b],nums[c], nums[d]]
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        if ((long)nums[0]+nums[1]+nums[2]+nums[3]>target){
            return list;
        }

        int length=nums.length;
        //开始枚举第一个数
        for (int i = 0; i < length - 3; ++i) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long)nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1]< target) {
                continue;
            }
            int number1 = nums[i];
            //开始枚举第二个数
            for (int j = i + 1; j < length - 2; ++j) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if ((long)nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int number2 = nums[j];
                //剩下两个数 用双指针法
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = (long) number1 + number2 + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(new ArrayList<>(Arrays.asList(number1, number2, nums[left], nums[right])));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum>target){
                        right--;
                        while (left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    } else {
                        left++;
                        while (left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> list = fourSum(nums, target);
        System.out.println(list);
    }
}
