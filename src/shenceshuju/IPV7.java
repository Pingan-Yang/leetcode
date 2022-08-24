package shenceshuju;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @ClassName IPV7
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/19 17:27
 * @Version:1.0
 */
public class IPV7 {
    private static final int N = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ipv7 = sc.nextLine();

//            String patten = "[\\d]+$";
//            Pattern pattern = Pattern.compile(patten);

            String[] split = ipv7.split("\\.");
            if (split[0]==null||split[0].equals("")||Integer.parseInt(split[0])==0){
                System.out.println("-1");
                continue;
            }
            String str = process(ipv7);
            System.out.println(str);
        }
    }

    private static String process(String str) {
        //ipv7->int
        String[] fields = str.split("\\.");
        long result = 0;
        for (int i = 0; i < N; i++) {

            String patten = "[\\d]+$";
            Pattern pattern = Pattern.compile(patten);
            //不是数字
            if (!pattern.matcher(fields[i]).matches()){
                return "-1";
            }

            //是数字  但是不在范围内
            if (Integer.parseInt(fields[i])>255||Integer.parseInt(fields[i])<0){
                return "-1";
            }

            result = result * 256 + Integer.parseInt(fields[i]);
        }
        return "" + result;

    }
}
