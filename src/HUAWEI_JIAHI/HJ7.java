package HUAWEI_JIAHI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HJ7
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/2 10:17
 * @Version:1.0
 */
public class HJ7 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            float f=sc.nextFloat();
            if(f-(int)f>=0.5){
                System.out.println((int)(f+1));
            }else{
                System.out.println((int)f);
            }
        }
    }
}
