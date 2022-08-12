package HUAWEI_JIAHI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName HJ24
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/2 10:05
 * @Version:1.0
 */

/**
 * 描述：
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 * 设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T1,T2,…,TK 使得T1<T2<......<T{i-1}<Ti且 Ti>T{i+1}>......>TK
 * 则称这K名同学排成了合唱队形。
 * <p>
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * <p>
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 * <p>
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * <p>
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 */
public class HJ24 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] data = new int[N];
            for (int i = 0; i < N; ++i) {
                data[i] = scanner.nextInt();
            }
            //开始处理 输入的数据
            int ans = process1(data);
            System.out.println(ans);
        }
    }

    /**
     * 动态规划：
     * 最长递增子序列的变种题目，只不过加了一个约束条件，需要左边递增右边递减的情况。
     * 1、先找到每一个位置i左侧的最长上升子序列长度left[i]
     * 2、再找到每一个位置i右侧的最长下降子序列长度right[i]
     * 3、然后求出所有位置的最长序列长度=左侧最长子序列长度+右侧最长子序列长度-1（因为该位置被算了两次，所以减1）
     * 4、然后用数目减去最长序列长度就是答案
     * @param data
     * @return
     */
    private static int process1(int[] data) {
        int n=data.length;
        //  dp[i]的值代表以nums[i]结尾的最长子序列长度
        int [] left=new int[n];//存储每个数左边小于其的数的个数
        int[] right=new int[n];//存储每个数右边小于其的数的个数
        //初始化的值为1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
        left[0] = 1;            //最左边的数设为1
        right[n - 1] = 1;        //最右边的数设为1
        //计算每个位置左侧最长递增
        for (int i = 0; i < n; i++) {
            left[i]=1;
            for (int j=0;j<i;++j){
                if (data[i]>data[j]){
                    left[i]=Math.max(left[j]+1,left[i]);
                }
            }
        }
        //计算每个位置右侧最长递减
        for (int i=n-1;i>=0;--i){
            right[i]=1;
            for (int j = n-1; j >i ; --j) {
                if (data[i]>data[j]){
                    right[i]=Math.max(right[j]+1,right[i]);
                }
            }
        }
        //记录：每个位置的值
        int max=0;
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=left[i]+right[i]-1;
            max=Math.max(max,res[i]);
        }
        return n-max;
    }
}

