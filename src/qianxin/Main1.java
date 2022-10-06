package qianxin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int m=Integer.parseInt(sc.next());
//        int[] dp =new int[51];
//        dp[0]=0;
//        dp[n]=1;
        int ans=func(new int[]{n,m});
        System.out.println(ans);

//        System.out.println(dp[50]);
    }


    public static int func(int[] nums){
        int T = 50;
        int n = nums[0];int m = nums[1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for(int i=1;i<Integer.MAX_VALUE;i++){
            int size = queue.size();
            for(int j=0;j<size;j++){
                int num = queue.poll();
                if(num==T) return i-1;
                queue.add(num+n);
                queue.add(num-m);
            }
        }
        return -1;
    }
}
