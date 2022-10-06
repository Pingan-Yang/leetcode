package pci;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int[] nums=new int[n];
        for (int i=0;i<n;++i){
            nums[i]=Integer.parseInt(sc.next());
        }
        process(nums);
    }

    private static void process(int[] nums) {
        int ans1=1;
        int ans2=1;
        for (int i=1;i<nums.length;++i){
            if (nums[i-1]>=nums[i]){
                ans1++;
            }else{
                ans2++;
                for(int k=i-2;k>=0;--k){
                    if (nums[k]<=nums[i]){
                        ans1-=1;
                    }
                }
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
        
    }
}
