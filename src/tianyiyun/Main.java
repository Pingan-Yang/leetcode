package tianyiyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int ans=process(str);
        System.out.println(ans);
    }

    private static int process(String str) {
        int yuan_coun=0;
        int n=str.length();
        for (int i=0;i<n;++i){
            if (str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                yuan_coun++;
            }
        }
        return yuan_coun>=n/2?n:yuan_coun+2;
    }
}
