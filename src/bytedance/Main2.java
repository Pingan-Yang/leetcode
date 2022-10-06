package bytedance;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 2
 * 5
 * 1 2 4 0 8
 * 7
 * 1 2 4 8 0 256 0
 *
 *
 * 1 3
 * 6 6
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i=0;i<T;++i){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for (int j=0;j<n;++j){
                nums[j]=sc.nextInt();
            }
            process(nums);
        }
    }

    private static void process(int[] nums) {
        //System.out.println(Arrays.toString(nums));
        int[] ans=new int[2];

        int max=Integer.MIN_VALUE;

        int l=0;
        int r=-1;
        while(l<nums.length){

            if (l!=0&&r<nums.length){
                l=r;
            }

            if (l!=0&&r>=nums.length){
                break;
            }
            while(r+1<nums.length&&nums[r+1]!=0){
                r++;
            }
            int maxValue=1;
            for (int i=l;i<=r;++i){
                maxValue*=nums[i];
            }
            if (maxValue>max){
                max=maxValue;
                //照题目的意思是 返回的应该是下标+1
                ans[0]=l+1;
                ans[1]=r+1;
            }
            l++;
            r+=2;
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
