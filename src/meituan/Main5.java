package meituan;

/**
 * @ClassName Main5
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 11:17
 * @Version:1.0
 */
import java.util.Scanner;

public class Main5 {
    public static boolean isNumber(String str) {
        // 这个代码意思是如果没有抛出异常 就证明是数字，抛出异常了那么就不是数字

        try {
            // parseInt 是将字符串转换为整数类型，返回一个int类型，如果字符串中有非数字类型字符，则会抛出一个NumberFormatException的异常
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String info="";

        // 1.输入员工类型
        // System.out.println("请输入员工类型:s(salesperson)/w(worker)");
        char type = input.next().charAt(0);

        if (type != 's' && type != 'w') {
            System.out.println("Error：员工类型输入错误");
        } else {
            // 2.输入工龄
            //System.out.println("请输入员工工龄:");
            String age = input.next();


            // 3.判断工龄输入是否正确
            if (isNumber(age)) {
                int num_age = Integer.parseInt(age);

                if (num_age < 0 || num_age > 7) {
                    System.out.println("Error：工龄输入错误");
                } else {

                    if (type == 's') {

                        //System.out.println("请输入本月订单总额");
                        String sale = input.next();
                        if (isNumber(sale)) {
                            float num_sale = Float.parseFloat(sale); //订单总额
                            int sum = 0; //工资总额
                            sum = (int)(2000 + 100 * num_age + num_sale * 0.001);


                            info = String.format("本月工资为：%d", sum);
                            System.out.println(info);

                        } else {
                            System.out.println("Error:订单总额输入错误");

                        }


                    } else if (type == 'w') {

                        //System.out.println("请输入本月加工零件总数");
                        String num = input.next();
                        if (isNumber(num)) {
                            float n_num = Float.parseFloat(num);//加工零件计件
                            int sum = 0;
                            sum = (int)(2000 + 200 * num_age + n_num * 0.5);


                            //System.out.println("本月工资为：%d" + sum);
                            info = String.format("本月工资为：%d", sum);
                            System.out.println(info);
                        } else {
                            System.out.println("Error:零件总数输入错误");

                        }


                    }
                }
            } else {
                System.out.println("Error：工龄输入错误");

            }

        }
    }

}


