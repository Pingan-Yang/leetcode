package xiecheng;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int [] nums=new int[n];
        for (int i=0;i<n;++i){
            nums[i]=Integer.parseInt(sc.next());
        }

        process(nums);
    }

    private static void process(int[] nums) {
        for(int num:nums){
            if (num%2==0){
                System.out.println(num);
            }else{
               char[] chars=(num+"").toCharArray();
                int i=0;
               for (;i<chars.length;++i){
                   if (Integer.parseInt(Character.toString(chars[i]))%2==0){
                       break;
                   }
               }
               if (i==chars.length){
                   System.out.println(-1);
               }else {
                   StringBuilder sb=new StringBuilder(num+"");
                   char c=sb.charAt(sb.length()-1);
                   sb.setCharAt(sb.length()-1,chars[i]);
                   sb.setCharAt(i,c);
                   System.out.println(sb.toString());
               }
            }
        }
    }
}
