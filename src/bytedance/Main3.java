package bytedance;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for (int i = 0; i <N ; i++) {
            maxProduct();
        }
    }

    private static void maxProduct() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int [n];

        for (int i = 0; i <n ; i++) {
            int temp=sc.nextInt();
            nums[i]=temp;
        }

        int left=0,right=0;
        int maxValue=1;
        int i=0;
        for (; i < nums.length; i++) {
            if (nums[i]>=1){
                left=i;
                maxValue=nums[left];
                break;
            }
        }

        int res=0;
        int start=0,end=Integer.MAX_VALUE;
        for(i=left+1;i<nums.length;++i){
            int num=nums[i];
            if (num==1){
                continue;
            }else  if(num==0){
                if (i+1<nums.length){
                    left=i+1;
                    right=i+1;
                    maxValue=1;
                    continue;
                }
            }else if (num>1){
                right=i;
                maxValue*=num;
            }

            if (maxValue>res){
                start=left;
                end=right;
                res=maxValue;
            }
        }
        System.out.println((start+1)+" "+(end+1));
    }
}
