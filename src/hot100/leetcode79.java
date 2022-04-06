package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName leetcode79
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/2 21:07
 * @Version:1.0
 */
public class leetcode79 {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }else if (k == word.length() - 1){
            return true;
        }

        visited[i][j] = true;
        // 用于记录结果
        boolean result = false;
        // 对相邻元素进行相同的操作
        // 定义一个方向矩阵
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            // 新索引的合理性判断
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                // 新的位置必须没有被访问过
                if (!visited[newI][newJ]) {
                    boolean flag = check(board, visited, newI, newJ, word, k+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }

        }
        // 回溯到上一层时，恢复该位置的未被访问的状态
        visited[i][j] = false;
        return result;
    }

    @Test
    public void test(){
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        boolean exist = exist(board, word);
        System.out.println("exist="+exist);
    }

    @Test
    public void  test02(){
        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,2)));
    }
}
