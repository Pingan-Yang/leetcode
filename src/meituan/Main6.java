package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int m=Integer.parseInt(sc.next());
        int[] ops=new int[m];
        int[] nums=new int[n];
        for (int i=1;i<=n;++i){
            nums[i-1]=i;
        }
        for (int i=0;i<m;++i){
            ops[i]=Integer.parseInt(sc.next());
            process(nums,ops[i]);
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void process(int[] nums, int data) {

        if (nums[0]==data){
            return;
        }

        if (nums[nums.length-1]==data){
            for (int i=nums.length-2;i>=0;--i){
                nums[i+1]=nums[i];
            }
            nums[0]=data;
            return;
        }
        int index=0;
        for (int i=0;i<nums.length;++i){
            if (nums[i]==data){
                index=i;
                break;
            }
        }

        for (int i=index-1;i>=0;--i){
            nums[i+1]=nums[i];
        }
        nums[0]=data;

    }


}
