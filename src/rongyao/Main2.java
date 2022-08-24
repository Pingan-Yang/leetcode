package rongyao;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 18:53
 * @Version:1.0
 */

/**
 * 5
 * my/2019-01-01T09:00:01
 * my/2019-01-01T09:00:01
 * abc/2018-12-24T08:00:00/test/you
 * 1/2018-12-24T08:00:00/test/Test1
 * 123/2018-12-24T08:00:09/test/me
 *
 *
 * 1/2018-12-24T08:00:00/test/Test1
 * abc/2018-12-24T08:00:00/test/you
 * 123/2018-12-24T08:00:09/test/me
 * my/2019-01-01T09:00:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        Set<String> set=new HashSet<>();
        for (int i=0;i<n;++i){
            set.add(sc.next());
        }

        String[] strs=new String[set.size()];

        int index=0;
        for (String s3:set){
            strs[index++]=s3;
        }


        Arrays.sort(strs,(s1,s2)->{
            String[] p1=s1.split("/");
            String[] p2=s2.split("/");

            String  time1=null;
            String  time2=null;

            for (String s : p1) {
                if (s.contains("-") && s.contains(":")) {
                    time1 = s;
                    break;
                }
            }

            for (String s : p2) {
                if (s.contains("-") && s.contains(":")) {
                    time2 = s;
                    break;
                }
            }
            LocalDateTime dateTime1=LocalDateTime.parse(time1);
            LocalDateTime dateTime2=LocalDateTime.parse(time2);
            if (!time1.equals(time2)){
                return dateTime1.isBefore(dateTime2)?-1:1;
            }else{
                if (s1.length()==s2.length()){
                   for (int i=0,j=0;i<s1.length()&&j<s2.length();){
                       if (s1.charAt(i)==s2.charAt(j)){
                           i++;
                           j++;
                       }
                       if (s1.charAt(i)>s1.charAt(j)){
                           return 1;
                       }else{
                           return -1;
                       }
                   }
                   return 0;
                }else{
                    return s1.length()-s2.length();
                }
            }
        });

      for (int i=0;i<strs.length;++i){
          System.out.println(strs[i]);
      }
    }
}
