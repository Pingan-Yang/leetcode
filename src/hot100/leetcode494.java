package hot100;

/**
 * @ClassName leetcode494
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/23 21:42
 * @Version:1.0
 */
public class leetcode494 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        // 回溯
        // 数组 nums 的每个元素都可以添加符号 + 或 -，
        // 因此每个元素有 2 种添加符号的方法，n 个数共有 2^n 种添加符号的方法,对应 2^n 种不同的表达式。
        // 当 n 个元素都添加符号之后，即得到一种表达式，如果表达式的结果等于目标数target，则该表达式即为符合要求的表达式。
        //
        //可以使用回溯的方法遍历所有的表达式
        // 回溯过程中维护一个计数器 count，当遇到一种表达式的结果等于目标数target 时，将 count 的值加 1。
        // 遍历完所有的表达式之后，即可得到结果等于目标数target 的表达式的数目

        backtrack(nums,target,0,0);
        return count;

    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        // base case
        if (index == nums.length) {
            // 数组走到了最后且target==sum  则count++
            if (target == sum) {
                count++;
                return;
            }
        }else {
            //遍历每一种可能
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
