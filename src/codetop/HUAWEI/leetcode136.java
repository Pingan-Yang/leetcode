package codetop.HUAWEI;

/**
 * @ClassName leetcode136
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/6 20:55
 * @Version:1.0
 */

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class leetcode136 {
    //异或运算：相同为0，相异为1
    // 0异或任何数为它本身
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i=0;i<nums.length;++i){
            ans^=nums[i];
        }
        return ans;
    }
}
