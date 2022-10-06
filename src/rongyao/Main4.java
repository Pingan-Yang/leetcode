package rongyao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.next());
        int n=Integer.parseInt(sc.next());
        List<int[]> list=new ArrayList<>();

        for (int i=0;i<n;++i){
            int start=Integer.parseInt(sc.next());
            int end=Integer.parseInt(sc.next());
            list.add(new int[]{start,end});
        }

        Collections.sort(list,(t1,t2)->t1[0]-t2[0]);
        int[] dp=new int[24];

        for (int i=0;i<list.size();++i){
            int start=list.get(i)[0];
            int end=list.get(i)[1];
            for (int j=23;j>=end;--j){
                //动态获取24小时的最长使用时间
               dp[j]=Math.max(dp[start]+end-start,dp[j]);
            }
        }
        System.out.println(dp[23]);
    }
}
