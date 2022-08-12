package HUAWEI_JIAHI;

/**
 * @ClassName HJ43
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/4 10:33
 * @Version:1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题：
 * <p>
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 * 数据范围：2≤n,m≤10  ， 输入的内容只包含 0≤val≤1
 * <p>
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 */
public class HJ43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] metrix = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    metrix[i][j] = sc.nextInt();
                }
            }

            dfs(metrix, 0, 0);
            for (Position p : path) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    static List<Position> path = new ArrayList<>();

    // DFS 搜索路径
    private static boolean process(int[][] metrix, int x, int y) {
        path.add(new Position(x, y));
        //标志为已走
        metrix[x][y] = 1;
        //走到了终点
        if (x == metrix.length - 1 && y == metrix[0].length - 1) {
            return true;
        }
        //表示向下可以走
        if (x + 1 < metrix.length && metrix[x + 1][y] == 0) {
            if (process(metrix, x + 1, y)) {
                return true;
            }
        }

        //向右可以走时
        if (y + 1 < metrix[0].length && metrix[x][y + 1] == 0) {
            if (process(metrix, x, y + 1)) {
                return true;
            }
        }

        //向上可以走时
        if (x - 1 >= 0 && metrix[x - 1][y] == 0) {
            if (process(metrix, x - 1, y)) {
                return true;
            }
        }

        //向左可以走时
        if (y - 1 >= 0 && metrix[x][y - 1] == 0) {
            if (process(metrix, x, y - 1)) {
                return true;
            }
        }

        //回溯
        path.remove(path.size() - 1);
        metrix[x][y] = 0;
        return false;

    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean dfs(int[][] map, int x, int y) {
        path.add(new Position(x, y));
        //标志该位置已被访问
        map[x][y] = 1;

        //出口
        if (x == map.length - 1 && y == map[0].length - 1) {
            return true;
        }

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] == 0) {
                if (dfs(map, newX, newY)) {
                    return true;
                }
            }
        }

        //回溯
        path.remove(path.size() - 1);
        map[x][y] = 0;
        return false;
    }
}

class Position {
    int x;
    int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

