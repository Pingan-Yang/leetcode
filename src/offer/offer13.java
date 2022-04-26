package offer;

import org.junit.Test;

/**
 * @ClassName offer13
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/26 20:27
 * @Version:1.0
 */
public class offer13 {
    int count = 0;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] used = new boolean[m][n];
        dfs(m, n, 0, 0, k, used);
        return count;
    }

    private void dfs(int m, int n, int i, int j, int k, boolean[][] used) {
        int a = bitCount(i);
        int b = bitCount(j);
        if (a + b > k) {
            return;
        }
        count++;
        used[i][j] = true;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : direction) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                if (!used[newI][newJ]) {
                    dfs(m, n, newI, newJ, k, used);
                }
            }
        }
    }
    //这里不可以回溯 因为访问过了就是访问过了
    //  used[i][j]=false;

    private int bitCount(int x) {
//        String s = String.valueOf(num);
//        int sum = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            sum += Integer.parseInt(s.charAt(i) + "");
//        }x
//        return sum;
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;

    }

    @Test
    public void test() {
        int m = 2;
        int n = 3;
        int k = 2;
        int count = movingCount(m, n, k);
        System.out.println(count);
    }
}
