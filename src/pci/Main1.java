package pci;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int[] nums=new int[n];
        int m=Integer.parseInt(sc.next());
        for (int i=0;i<n;++i){
            nums[i]=Integer.parseInt(sc.next());
        }
        while(sc.hasNext()){
            int l=Integer.parseInt(sc.next());
            int r=Integer.parseInt(sc.next());
            process(nums,l,r);
        }
    }

    private static void process(int[] nums, int l, int r) {
        int sum=0;
        for (int i=l-1;i<r;++i){
            sum+=nums[i];
        }
        System.out.println(sum);
    }
}
