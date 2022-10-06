package xiecheng;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(sc.next());
        }

        int maxDiv=0;
        int index=0;

        for (int i = 1; i < n; i++) {
            int curDiv=Math.abs(nums[i]-nums[i-1]);
            if (curDiv>maxDiv){
                maxDiv=curDiv;
                index=i-1;
            }
        }
        if (index+2<n&&nums[index]==nums[index+2]){
            nums[index+1]=nums[index];
        }else{
            if (index==0){
                nums[0]=nums[1];
            }else if(index==n-2){
                nums[n-1]=nums[n-2];
            }else{
                nums[index]=Math.abs(nums[index+1]+nums[index-1])/2;
            }
        }
        maxDiv=0;
        for (int i=1;i<n;++i){
            int curDiv=Math.abs(nums[i]-nums[i-1]);
            maxDiv=Math.max(maxDiv,curDiv);
        }
        System.out.println(maxDiv);
    }
}
