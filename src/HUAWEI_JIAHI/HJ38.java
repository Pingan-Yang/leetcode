package HUAWEI_JIAHI;

/**
 * @ClassName HJ38
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/3 16:52
 * @Version:1.0
 */

import java.util.Scanner;

/**
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半;再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 数据范围：输入的小球初始高度满足 1≤n≤1000  ，且保证是一个整数
 *
 * 输入起始高度，int型
 *
 *分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 */
public class HJ38 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            double height=sc.nextDouble();
            double sum=height;
            for (int i=0;i<4;++i){
                height/=2;
                sum+=height*2;
            }
            System.out.println(sum);
            System.out.println(height/2);
        }
    }
}
