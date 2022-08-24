package shenceshuju;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/22 20:57
 * @Version:1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        long[] data=new long[n];
        for (int i=0;i<n;++i){
            data[i]=Long.parseLong(sc.next());
        }

        Arrays.sort(data);
        long ans=process(data);
        System.out.println(ans);
    }

    private static long process(long[] data) {
        long max=Long.MIN_VALUE;
        for (int i=0;i<data.length;++i){
            for (int j=i+1;j<data.length;++j){
                long temp=data[i]+data[j]-(j-i);
                max= Math.max(max, temp);
            }
        }
        return max;
    }
}
