package tianyiyun;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.sound.midi.MidiFileFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;++i){
            nums[i]=sc.nextInt();
        }
        int ans=process(nums);
        System.out.println(ans);
    }

    private static int process(int[] nums) {
        int n=nums.length;
        if (n==2){
            return nums[0]*nums[1]%2==0?0:1;
        }
        int i = 1;
        for (; i < n; i++) {
            if (nums[i]*nums[i-1]%2!=0){
               break;
            }
        }
        if (i==n){
            return 0;
        }
        i=1;
        int count=0;
        for (i=0; i < n; i++) {
           if (nums[i]%2==0){
               continue;
           }else{
               if (i-1>=0&&i+1<n&&nums[i-1]%2!=0&&nums[i]%2!=0&&nums[i+1]%2!=0){
                   count++;
                   if (i+3>=n){
                       break;
                   }
               }else if (i-1>=0&&i+1<n&&nums[i]%2!=0&&(nums[i+1]%2!=0||nums[i-1]%2!=0)){
                   count++;
                   if (n+2>=n){
                       break;
                   }
               }
           }

        }
        return count;
    }
}
