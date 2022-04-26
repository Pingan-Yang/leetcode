package offer;

/**
 * @ClassName offer12
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/26 20:04
 * @Version:1.0
 */
public class offer12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean flag = dfs(board, i, j, used, chars, 0);
                if (flag == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] used, char[] chars, int k) {
        if (board[i][j] != chars[k]) {
            return false;
        }
        if (k == chars.length - 1) {
            return true;
        }
        boolean ans = false;
        used[i][j] = true;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dirc : direction) {
            int newI = i + dirc[0];
            int newJ = j + dirc[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                //新的位置必须没有被访问过
                if (!used[newI][newJ]) {
                    boolean flag = dfs(board, newI, newJ, used, chars, k + 1);
                    if (flag == true) {
                        ans = true;
                        break;
                    }
                }
            }
        }
        // 回溯到上一层时，恢复该位置的未被访问的状态
        used[i][j] = false;
        return ans;
    }
}
