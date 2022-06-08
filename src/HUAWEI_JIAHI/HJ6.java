package HUAWEI_JIAHI;

import java.util.Scanner;

/**
 * @ClassName HJ6
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/2 9:51
 * @Version:1.0
 */
public class HJ6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int target=sc.nextInt();
            int y=2;
            while(target!=1){
                if(target%y==0){
                    System.out.print(y+" ");
                    target/=y;
                }else{
                    if(y>target/y) y=target;
                    else y++;
                }
            }
        }
    }
}
