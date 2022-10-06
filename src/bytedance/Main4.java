package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main4 {
    static int n,m,count=0;
    static int [][]arr;
    static int []flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n+1][n+1];
        flag=new int[n+1];
        for(int i=1;i<=m;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            arr[u][v]=arr[v][u]=1;
        }
        for(int i=1;i<=n;i++) {
            DFS(i,i,1);
            Arrays.fill(flag,0);
//			System.out.println("次数为"+i+"时，count为:"+count);
//			System.out.println();
        }
        System.out.println(count);
    }
    private static void DFS(int pot,int st,int bu) {
//		System.out.println("进入点:"+st);
        if(bu==4) {
            count++;
        }
        if(bu>4) {
            return;
        }
//		System.out.println("此时点:"+st+"的count为:"+count);
//		System.out.println("此时步数为:"+bu);
        flag[st]=1;
        for(int i=1;i<=n;i++) {
            if(arr[st][i]==1 && flag[i]==0) {
                DFS(pot,i,bu+1);
                flag[i]=0;
            }
            if(bu==3 && i==n) {//i==n使这个判断条件只会出现一次
                if(arr[st][pot]==1) {
                    count++;
                }
            }
        }
        return;
    }
}
