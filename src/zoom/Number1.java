package zoom;

/**
 * @ClassName Number1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/10 21:23
 * @Version:1.0
 */

import java.util.*;

/**
 * 1.有一颗有根树 根节点为1号节点 每个节点为红色或蓝色 假设第i个节点的权值为从根节点到该节点红蓝节点的数量之差 请你返回所有节点的权值之和
 * 输入
 * 第一行输入n个节点 第二行为每个节点的颜色 接下来n-1行为a b节点之间有一条线
 * 5
 * RBBRB
 * 1 5
 * 2 5
 * 1 3
 * 5 4
 * 输出
 * 3
 */
public class Number1 {
    static long res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        char[] ch = sc.nextLine().toCharArray();
        // tree存储与key直接相邻的节点
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < num - 1; i++) {
            int[] n = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // tree.computeIfAbsent(n[0], k -> new ArrayList<>()).add(n[1]);;的意思表示key为n[0]的建值对是否存在，返回的是value的值。
            //如果存在则获取n[0]的值，并操作值的List<Integer>添加数据n[1]。
            //如果不存在，则调用方法，新创建List<Integer>结构，将n[1]添加到List<Integer>中，再存入到hashMap中。
            tree.computeIfAbsent(n[0], k -> new ArrayList<>()).add(n[1]);
            tree.computeIfAbsent(n[1], k -> new ArrayList<>()).add(n[0]);
        }
        long blue = 0;
        long red = 0;
        boolean[] visited = new boolean[num + 1];
        visited[0] = true;
        dfs(1, blue, red, visited, ch, tree);
        System.out.println(res);
    }

    public static void dfs(int cur, long blue, long red, boolean[] visited, char[] ch, Map<Integer, List<Integer>> tree) {
        //如果当前节点已访问，直接返回
        if (visited[cur])
            return;
        if (ch[cur - 1] == 'B') {
            res = res + Math.abs(red - blue - 1);
        } else {
            res = res + Math.abs(red + 1 - blue);
        }
        visited[cur] = true;
        for (int i : tree.get(cur)) {
            if (ch[cur - 1] == 'B') {
                dfs(i, blue + 1, red, visited, ch, tree);
            } else {
                dfs(i, blue, red + 1, visited, ch, tree);
            }
        }
    }
}

