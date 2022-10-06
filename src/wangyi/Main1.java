package wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int k=Integer.parseInt(sc.next());
        int t=Integer.parseInt(sc.next());
        if (k<=t){
            System.out.println(-1);
            return;
        }

        StringBuilder sb=new StringBuilder();
        if (k-1==t){
            for (int i=1;i<=k;++i){
                sb.append(1);
            }
            for (int i=k+1;i<=n;++i){
                sb.append(0);
            }
            if (sb.length()>n){
                System.out.println(-1);
                return;
            }

        }else{
            for (int i=1;i<=t+1;++i){
                sb.append(1);
            }
            int m=k-t-1;
            while(m>0){
                sb.append("01");
                m--;
            }
            if (sb.length()>n){
                System.out.println(-1);
                return;
            }
        }


        System.out.println(sb.toString());


    }
}
