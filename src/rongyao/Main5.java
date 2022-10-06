package rongyao;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=Integer.parseInt(sc.next());
        int[]  nums=new int[M];

        for (int i=0;i<M;++i){
            nums[i]=Integer.parseInt(sc.next());
        }

        Arrays.sort(nums);
        int sum=0;
        for (int i=0;i<M;++i){
            sum+=nums[i];
        }
        int avg=sum/M;
        int ans=0;
        for (int i=0;i<M&&ans<=avg;++i){
            ans+=nums[i];
        }

        System.out.println(ans);
    }
}
