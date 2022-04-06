package hot100;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode15
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/31 19:28
 * @Version:1.0
 */
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        // a+b+c=0==>a+b=-c

        // 先对数组排序
        Arrays.sort(nums);
        // 对特殊情况进行特殊处理
        if (nums[0] > 0 || nums[0] + nums[1] > 0) {
            return list;
        }
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            //对第一个数进行枚举
            if (i != 0 && nums[i] == nums[i - 1]) {
                //去除重复元素
                continue;
            }
            int target =-nums[i];
            // 使用双指针法 去找第二和第三个数
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    //去重
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] > target) {
                    right--;
                    //去重
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
}
