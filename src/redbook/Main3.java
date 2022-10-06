package redbook;

import sun.security.util.DerEncoder;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int id=sc.nextInt();
        int[][] nums=new int[n][m];

        for (int i=0;i<n;++i){
            int[] temp=new int[m];
            for (int j=0;j<m;++j){
                temp[j]=sc.nextInt();
            }
            nums[i]=temp;
        }
        System.out.println(solution(nums,id));
    }

    private static int solution(int[][] nums, int id) {
        int n=nums.length;
        int m=nums[0].length;
        int[] sum=new int[n];
        for (int i = 0; i < n; i++) {
            int sumTmp=0;
            for (int j=0;j<m;++j){
                sumTmp+=nums[i][j];
            }
            sum[i]=sumTmp;
        }
        String[] str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]= String.valueOf(sum[i]) + "_" + String.valueOf(i+1);
        }

        Arrays.sort(str,(o1, o2) -> {
            int p1 = Integer.parseInt(o1.split("_")[0]);
            int p2 = Integer.parseInt(o2.split("_")[0]);
            if (p1==p2){
                return Integer.parseInt(o1.split("_")[1])-Integer.parseInt(o2.split("_")[1]);
            }else{
                return p2-p1;
            }
        });

        for (int i = 0; i < n; i++) {
            int numTemp=Integer.parseInt(str[i].split("_")[1]);
            if (numTemp==id){
                return i+1;
            }
        }
        return -1;
    }
}
