package HUAWEI_JIAHI;

import java.io.*;

/**
 * @ClassName HJ17
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/23 13:59
 * @Version:1.0
 */
public class HJ17 {
}

class Main17{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // String str;
        String[] in = reader.readLine().split(";");
        int x = 0;
        int y=0;
        for(String s:in){
            if(!s.matches("[WASD][0-9]{1,2}")){
                continue;
            }
            int val=Integer.valueOf(s.substring(1));
            switch(s.charAt(0)){
                case 'W':
                    y+=val;
                    break;
                case 'S':
                    y-=val;
                    break;
                case 'A':
                    x-=val;
                    break;
                case 'D':
                    x+=val;
                    break;
            }
        }
        System.out.println(x+","+y);

    }
}
