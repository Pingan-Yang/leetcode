package offer;

import java.util.Arrays;

/**
 * @ClassName offer39
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/5 20:20
 * @Version:1.0
 */
public class offer39 {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //摩尔投票法： 核心理念为 票数正负抵消 。
    // 此方法时间和空间复杂度分别为 O(N)和)O(1)。

    //设输入数组 nums 的众数为 x ，数组长度为 n 。
    //推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 -1，则一定有所有数字的 票数和 > 0
    //推论二： 若数组的前 a个数字的 票数和=0 ，则 数组剩余(n−a) 个数字的 票数和一定仍 >0，
    // 即后 (n-a)个数字的 众数仍为 x 。

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;

    }
}
