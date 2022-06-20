package codetop.HUAWEI;

/**
 * @ClassName leetcode980
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/16 22:59
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 */
public class leetcode980 {
//    int path_count;//路径条数
//    int zero_count;//还需要走过空格数
//    public int uniquePathsIII(int[][] grid) {
//
//        int x = 0, y = 0;
//        int m = grid.length;
//        int n = grid[0].length;
//        //找到入口
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 1) {
//                    x = i;
//                    y = j;
//                    //开始的格子也是需要走的
//                    zero_count++;
//                }
//                if (grid[i][j] == 0) {
//                    zero_count++;
//                }
//            }
//        }
//        // 参数，起始坐标x，y，当前还需走过的空方格，路径条数，二维网格
//        dfs(x, y, grid);
//        return path_count;
//    }
//
//    private void dfs(int x, int y, int[][] grid) {
//        //判断是否越界
//        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
//            return;
//        }
//        //遇到障碍物结束
//        if (grid[x][y] == -1) {
//            return;
//        }
//        //不仅要走到结束方格，还要每一个无障碍方格走一遍
//        if (grid[x][y] == 2 && zero_count != 0) {
//            return;
//        }
//        //表示走到结尾并且每一个空格都走过了
//        if (grid[x][y] == 2 && zero_count == 0) {
//            path_count++;
//            return;
//        }
//
//        int temp = grid[x][y];
//        //标记已经走过
//        grid[x][y] = -1;
//        //将需要走过的空格数-1
//        zero_count--;
//        //开始回溯
//        dfs(x + 1, y, grid);
//        dfs(x - 1, y, grid);
//        dfs(x, y + 1, grid);
//        dfs(x, y - 1, grid);
//        //回溯时要将上一步的走过的空格标记为未走过
//        grid[x][y] = temp;
//        zero_count++;
//    }


    int zeroCount;
    int pathCount;

    public int uniquePathsIII(int[][] grid) {
        //找到入口
        int x = 0;
        int y = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    //开始的格子也是需要走的
                    zeroCount++;
                }
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        dfs(x, y, grid);
        return pathCount;
    }

    private void dfs(int x, int y, int[][] grid) {
        //边界判断
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        //遇到障碍物结束
        if (grid[x][y] == -1) {
            return;
        }

        //到结尾但是还有空格没走完
        if (grid[x][y] == 2 && zeroCount != 0) {
            return;
        }
        //到结尾 空格走完
        if (grid[x][y] == 2 && zeroCount == 0) {
            pathCount++;
            return;
        }

        //标记该空格走过
        int temp = grid[x][y];
        grid[x][y]=-1;
        zeroCount--;
        //开始回溯
        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
        grid[x][y] = temp;
        zeroCount++;
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        int ans = uniquePathsIII(grid);
        System.out.println(ans);
    }
}
