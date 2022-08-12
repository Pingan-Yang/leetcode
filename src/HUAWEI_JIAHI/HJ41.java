package HUAWEI_JIAHI;

/**
 * @ClassName HJ
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/3 17:20
 * @Version:1.0
 */

import java.util.HashSet;
import java.util.Scanner;

/**
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * 注：
 * 称重重量包括 0
 * <p>
 * 每组输入数据满足 1≤n≤10  ， 1≤mi≤2000  ， 1≤xi≤10
 * <p>
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 * <p>
 * 利用给定的砝码可以称出的不同的重量数
 */
public class HJ41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            int[] counts = new int[n];
            for (int i = 0; i < n; i++) {
                counts[i] = sc.nextInt();
            }
            int ans = process(n, weight, counts);
            System.out.println(ans);

        }
    }

    //暴力遍历
    private static int process(int n, int[] weight, int[] counts) {
        //存放所有可能的结果
        HashSet<Integer> count=new HashSet<>();
        //存放当前所有的结果
        HashSet<Integer> cur=new HashSet<>();
        count.add(0);
        //对砝码按种类遍历，每种都有0-xi个数供选择
        for (int i = 0; i < n; ++i) {
            //当前质量砝码个数遍历
            for (int j=0;j<=counts[i];++j){
                //对已经保存的质量分别加上当前j数量的砝码i得到新的质量，并添加当前新生成的质量集合cur
                for (int mass:count){
                    cur.add(j*weight[i]+mass);
                }
            }
            //把当前新生成质量cur加入到count中，得到前i种砝码可获得的全部质量
            for(int mass:cur){
                count.add(mass);
            }
            //清楚当前cur质量集合
            cur.clear();

        }
        return count.size();
    }
}
