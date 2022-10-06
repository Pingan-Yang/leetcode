package HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=Integer.parseInt(sc.next());
        int[] nums=new int[m];
        for (int i=0;i<m;++i){
            nums[i]=Integer.parseInt(sc.next());
        }
        int n=Integer.parseInt(sc.next());
        //-------------------
       int i=0,j=1;
       int maxc=1,money=nums[0];
       int cost=0;
       int location=Integer.MAX_VALUE;
       while(j<m){
           while(j<m&&cost+(nums[j]-nums[j-1])*(j-i)<=n){
               cost+=(nums[j]-nums[j-1]*(j-i));
               j++;
           }
           if (j-i>maxc){
               maxc=j-i;
               money=nums[j-1];
               location=i;
           }
           i++;
       }
        System.out.println(maxc+" ");
       int count =n;
       if (location==Integer.MAX_VALUE){
           System.out.println(n);
       }else{
           while(nums[location]<=money){
               count-=money-nums[location++];
           }
           System.out.println(count);
       }

    }

    private static int[] process(int m, int[] nums, int n) {

        Arrays.sort(nums);
        if (nums[0]+n<nums[1]){
            return new int[]{1,n};
        }
        int maxCount=0;
        int minMoney=Integer.MAX_VALUE;
        int len=nums.length;
        for(int i=len-1;i>=1;i--){
            int temp=n;
            int target=nums[i];
            int count=1;
            int k=0;
            for (int j=i-1;j>=0;--j){
                temp-=(target-nums[j]);
                k=j;
                if (temp>=0){
                    ++count;
                }else{
                    break;
                }
            }
            if (maxCount<maxCount){
                maxCount=count;
                if (temp>=0){
                    minMoney=temp;
                }else{
                    minMoney=temp+nums[k];
                }
            }
        }
        return new int[]{maxCount,minMoney};
    }
}
