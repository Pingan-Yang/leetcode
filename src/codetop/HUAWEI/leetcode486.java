package codetop.HUAWEI;

/**
 * @ClassName leetcode486
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/30 15:41
 * @Version:1.0
 */

/**
 * 486. 预测赢家
 *  给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *  玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。
 *  开始时，两个玩家的初始分值都是 0 。
 *  每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 *  玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。
 * 如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 */
public class leetcode486 {
    //递归

    public boolean PredictTheWinner(int[] nums) {
        return play(nums, 0, nums.length - 1) >= 0;
    }
    private int play(int[] nums, int lo, int hi) {
        if (lo > hi) return 0;
        int planA = nums[lo] - play(nums, lo + 1, hi);
        int planB = nums[hi] - play(nums, lo, hi - 1);
        return Math.max(planA, planB);
    }
}
