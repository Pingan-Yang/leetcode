package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName offer61
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/28 20:41
 * @Version:1.0
 */
public class offer61 {
    public boolean isStraight(int[] nums) {
        //问题转化：
        // 除了大小王外:
        // 所有的牌不重复
        // 这五张牌里max-min<5
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (!set.isEmpty() && set.contains(num)) {
                return false;
            }
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);

        }
        return max-min<5;
    }

    @Test
    public void test() {
        // int[] nums={1,2,3,4,5};
        int[] nums = {0, 0, 1, 2, 5};
        boolean b = isStraight(nums);
        System.out.println(b);
    }
}
