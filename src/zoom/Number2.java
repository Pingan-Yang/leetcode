package zoom;

/**
 * @ClassName Number2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/11 9:48
 * @Version:1.0
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 完成股票推荐系统设计，如果一个人关注了a又关注了b 则系统会给只关注a没关注b的人推荐关注b，请返回应该给此人推荐关注几个股票
 * 输入
 * 第一行输入q表示操作次数
 * 接下来输入一次操作
 * 共有两种操作
 * 1.注册
 * 格式为
 * 1 name n 表示有一个name的人关注了n个股票
 * 第二行输入n个字符串表示这n个股票 n个字符串不相同
 * 2.查询
 * 格式为
 * 输入2 name 表示查询系统会给此人推荐多少股票
 * 保证至少有一次查询
 * 例
 * 5
 * 1 Alice 2
 * Zoom Apple
 * 2 Bob
 * 2 Alice
 * 1 Bob 2
 * Apple MicroSoft
 * 2 Bob
 * 输入
 * error
 * 0
 * 1
 */
public class Number2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        UF uf = new UF(500010);
        Map<String, Integer> map1 = new HashMap<>(); // 每个名字在树的映射
        Map<String, Integer> map2 = new HashMap<>(); // 股票和 index 映射
        Map<String, Integer> map3 = new HashMap<>(); // 名字和股票数目的映射
        int index = 0;
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                String name = sc.next();
                int n = sc.nextInt();
                map3.put(name, n);
                String stock = sc.next();
                int currIndex = -1;
                if (map2.containsKey(stock)) {
                    currIndex = map2.get(stock);
                } else {
                    currIndex = index++;
                }
                map1.put(name, currIndex);
                map2.put(stock, currIndex);
                for (int j = 1; j < n; j++) {
                    int t = -1;
                    stock = sc.next();
                    if (map2.containsKey(stock)) {
                        t = map2.get(stock);
                    } else {
                        t = index++;
                    }
                    map2.put(stock, t);
                    uf.union(currIndex, t);
                    currIndex = t;
                }
            } else {
                String name = sc.next();
                if (!map3.containsKey(name)) {
                    System.out.println("error");
                    continue;
                }
                int root = uf.find(map1.get(name));
                int diff = uf.size[root] - map3.get(name);
                System.out.println(diff);
            }
        }
    }


    /**
     * 并查集
     */
    static class UF {
        int[] parent;
        int[] rank;
        int[] size;

        UF(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] >= rank[rootY]) {
                    if (rank[rootX] == rank[rootY]) {
                        rank[rootX]++;
                    }
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                }
            }
        }

    }
}
