package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**

 * @ClassName offer60
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/20 21:25
 * @Version:1.0
 */
public class offer60 {
    private int[] count;
    //暴力递归枚举
    public double[] dicesProbability(int n) {
        count = new int[6 * n + 1];
        // 回溯算法枚举所有情况
        backtrack(n, 0, 0);
        int kind = (int) Math.pow(6, n);
        // 所有可能出现的值的个数是 6 * n - n = 5 * n;
        double[] res = new double[5 * n + 1];
        for(int i = n; i < count.length; i++) {
            res[i-n] = count[i] * 1.0 / kind;
        }
        return res;
    }

    public void backtrack(int n, int index, int sum) {
        // 递归出口
        if (index == n) {
            // 将当前值出现的个数+1
            count[sum]++;
            return;
        }

        for(int i = 1; i <= 6; i++) {
            // 依次将当前骰子设置为1, 2, 3 ... 6, 然后递归后边的骰子
            backtrack(n, index + 1, sum + i);
        }
    }

    @Test
    public void test(){
        int n=2;
        double[] res = dicesProbability(n);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(count));

    }
}
