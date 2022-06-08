package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName offer51
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/26 20:10
 * @Version:1.0
 */
//数组中的逆序对
public class offer51 {
    // 暴力解法
    public int reversePairs1(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    //利用归并排序进行优化
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        //因为需要修改数组  所以将数组先拷贝一份
        int[] copy = Arrays.copyOf(nums, n);
        // 还需要一份辅助数组
        int[] temp = new int[n];

        //递归调用并返回结果
        return reversePairs(copy, 0, n - 1, temp);
    }

    /**
     * nums[left..right] 计算有序对 并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        //下面将数组进行过拆分
        int leftReversePairs = reversePairs(nums, left, mid, temp);
        int rightReversePairs = reversePairs(nums, mid + 1, right, temp);
        //将两个有序数组进行合并，并计算合并过程中的逆序对
        int mergeReversePairs = mergeAndCount(nums, left, mid, right, temp);
        return leftReversePairs + rightReversePairs + mergeReversePairs;
    }

    /**
     * nums1[left,mid]  nums2[mid+1,right] 均有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; ++i) {
            temp[i] = nums[i];
        }
        //记录逆序对的个数
        int count = 0;
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; ++k) {
            //这里一定要加<=号
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }


    @Test
    public void test() {
        int[] nums = {5, 4, 3, 2, 1};
        int reversePairs = reversePairs(nums);
        System.out.println("reversePairs:" + reversePairs);
    }
}
