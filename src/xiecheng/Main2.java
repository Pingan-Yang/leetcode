package xiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int [][] nums=new int[n][3];
        for (int i=0;i<n;++i){
            for (int j=0;j<3;++j){
                nums[i][j]=Integer.parseInt(sc.next());
            }

        }
        process(nums);
    }

    //y o u
    private static void process(int[][] nums) {
        for (int[] num:nums){
            int ans=0;
            int count_o=num[1];
            int count_y=num[0];
            int count_u=num[2];
            int min=Math.min(Math.min(count_o,count_u),count_y);
            ans+=min*2;
            int gap=0;
            if (count_o-min==2){
                gap=1;
            }else if (count_o-min>2){
                gap=count_o-min-1;
            }

            ans+=gap;
            System.out.println(ans);
        }
    }
}
