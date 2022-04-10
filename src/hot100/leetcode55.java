package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode55
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/10 21:14
 * @Version:1.0
 */
public class leetcode55 {
    public boolean canJump(int[] nums) {
        //对于位置y可以到达的条件，存在一个位置x 使得x+nums[x]>=y
        // 所以对于x的右边的这些位置x+1,x+2,...,x+nums[x]均可到达
        if (nums.length==1){
            return true;
        }
        // 记录目前该位置能够跳跃到的最远位置
        int maxLength=0;
        int curIndex=0;
        while (curIndex<nums.length){
            // 如果能够跳跃的最大距离 已经小于当前的index，则说明无法到达该index,直接返回false
            if (maxLength<curIndex){
                return false;
            }

            // 两个if 条件不能颠倒顺序

            // 如果当前位置能够跳跃的最大距离比之前的记录值大，则更新maxLength
            if (curIndex+nums[curIndex]>maxLength){
                maxLength=curIndex+nums[curIndex];
            }
            // 如果当前能够跳跃的最大距离已经超过了数组长度，则证明可以到达数据末尾，返回true
            if (maxLength>=nums.length-1){
                return true;
            }
            curIndex++;
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums={3,2,1,0,4};
        boolean ans = canJump(nums);
        System.out.println(ans);
    }
}
