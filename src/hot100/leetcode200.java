package hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode200
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/11 20:51
 * @Version:1.0
 */
public class leetcode200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] data = queue.poll();
                        int x = data[0];
                        int y = data[1];
                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new int[]{x + 1, y});
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new int[]{x - 1, y});
                        }
                        if (y + 1 < col && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new int[]{x, y + 1});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new int[]{x, y - 1});
                        }
                    }
                }
            }
        }
        return result;
    }
}
