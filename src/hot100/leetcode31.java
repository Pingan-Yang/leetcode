package hot100;

/**
 * @ClassName leetcode31
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/6 22:21
 * @Version:1.0
 */
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        // 1 2 3 4 5
        // 1 2 3 5 4
        // 1 2 4 3 5
        // 1 2 4 5 3
        // 1 2 5 4 3
        // 1 2 5 3 4
        // ...
        // 5 4 3 2 1
        int n = nums.length;
        if (n < 2) {
            return;
        }

    }
}
