package gaotu;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split(" ");
        String res=multiply(str1[0],str1[1]);
        System.out.println(res);
    }

    private static String multiply(String s1, String s2) {
        if (s1.equals("0")||s2.equals("0")){
            return "0";
        }
        String ans="0";
        int m=s1.length();
        int n=s2.length();
        for (int i = n-1; i >=0 ; i--) {
            StringBuilder sb=new StringBuilder();
            int add=0;
            for(int j=n-1;j>i;j--){
                sb.append(0);
            }
            int y=s2.charAt(i)-'0';

            for(int j=m-1;j>=0;j--){
                int x=s1.charAt(j)-'0';
                int product=x*y+add;
                sb.append(product%10);
                add=product/10;
            }
            if(add!=0){
                sb.append(add%10);
            }
            ans=addStrings(ans,sb.reverse().toString());
        }
        return  ans;
    }

    private static String addStrings(String s1, String s2) {
        int i=s1.length()-1,j=s2.length()-1,add=0;
        StringBuilder ans=new StringBuilder();
        while(i>=0||j>=0||add!=0){
            int x=i>=0?s1.charAt(i)-'0':0;
            int y=j>=0?s2.charAt(j)-'0':0;
            int res=x+y+add;
            ans.append(res%10);
            add=res/10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
