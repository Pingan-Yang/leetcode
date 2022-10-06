package xiecheng;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(sc.next());
        }

        process(arr);

    }

    private static void process(int[] arr) {
        int n=arr.length;
        int max=0;
        int index=0;
        int[] num=new int[n-1];
        for (int i = 0; i < n-1; i++) {
            num[i]=Math.abs(arr[i]-arr[i+1]);
            if (num[i]>max){
                max=num[i];
                index=i;
            }
        }
        if (index==0||index==n-1){
            num[index]=0;
            max=0;
            for (int nn:num) {
                if (nn > max) {
                    max = nn;
                }
            }
            System.out.println(max);
            return;
        }
        int max1=0,max2=0;
        int tmp=arr[index];
        arr[index]=(arr[index-1]+arr[index+1])/2;
        for (int i = 0; i < n - 1; i++) {
            num[i]=Math.abs(arr[i]-arr[i+1]);
            if (num[i]>max1){
                max1=num[i];
            }
        }
        arr[index]=tmp;
        arr[index+1]=(arr[index]+arr[index+2])/2;
        for (int i = 0; i < n - 1; i++) {
            num[i]=Math.abs(arr[i]-arr[i+1]);
            if (num[i]>max2){
                max2=num[i];
            }
        }
        System.out.println(Math.min(max1,max2));
    }
}

