package shenceshuju;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @ClassName ipv71
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/22 20:26
 * @Version:1.0
 */

/**
 * 1.0.0.0.0.0.2
 * 1.0.0....2
 * 1......2
 */
public class ipv71 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String ipv7=sc.next();
            String[] split = ipv7.split("\\.");
            if (ipv7.charAt(0)=='.'||ipv7.charAt(ipv7.length()-1)=='.'){
                System.out.println("-1");
            }else{
                System.out.println(process(split));
            }

        }
    }

    private static String process(String[] split) {
        if (split[0].equals("")||split[split.length-1].equals("")){
            return "-1";
        }

        long res=0;

        long b=256;


        String patten = "[\\d]+$";
        Pattern pattern = Pattern.compile(patten);


        for (String s:split){
            //不是数字
            if (!pattern.matcher(s).matches()){
                return "-1";
            }

            if (Long.valueOf(s)<0||Long.valueOf(s)>255){
                return "-1";
            }

            if (s.equals(""))
                continue;
            long temp=Long.valueOf(s);
            res*=b;
            res+=temp;
        }

        return res+"";

    }
}
