package weizhong;


import java.util.*;

/**
 * 一天你正在玩一个游戏，游戏中给定一个数a，你需要通过一些简单的移位操作来将其变成b，在每次操作中，
 * 你可以将当前的数x变成以下六个数中的一个：
 *
 * x * 2，x * 4，x * 8，x / 2 (如果x被2整除)，x / 4 (如果x被4整除)，x / 8 (如果x被8整除)
 *
 * 例如，如果当前的数x = 12，你可以将他变成24、48、96、6、3，你不能将其变成x / 8，因为12不能被8整除。
 *
 * 现在请问将给定的初始值a通过上述操作变成目标值b需要的最少的操作次数。
 *
 * 第一行包含一个正整数t (1≤ t ≤100) ，表示数据组数。
 *
 * 接下来n行每行包括两个空格隔开的正整数a和b，分别表示初始值和目标值。
 *
 *
 * 输出n行，每行一个数表示通过上述操作将初始值a变成目标值b需要的最少的操作次数，如果最终无法得到b，则输出-1 。
 *
 *
 * 4
 * 3 6
 * 16 2
 * 12 4
 * 1024 1
 *
 * 1
 * 1
 * -1
 * 4
 */
public class Main2 {
    static boolean flag=false;
    static List<Integer>list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        while(n!=0){
            int srcNum=Integer.parseInt(sc.next());
            int targetNum=Integer.parseInt(sc.next());
            if (srcNum==targetNum){
                System.out.println(0);
            }else if(targetNum==0){
                System.out.println(-1);
            } else{
                int ans=process(srcNum,targetNum);
                System.out.println(ans);
            }
        }
    }

    private static int process(int srcNum, int targetNum) {
        //贪心即可

        return 0;
    }
}
