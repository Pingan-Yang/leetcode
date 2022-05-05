package offer;

import org.junit.Test;

/**
 * @ClassName offer65
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/4 22:39
 * @Version:1.0
 */
public class offer65 {
    public int add(int a, int b) {
        //无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）

        //n=a⊕b  非进位和：异或运算
        //c=a&b<<1 进位：与运算+左移一位

        //s=a+b⇒s=n+c

        //循环求 n 和 c ，直至进位 c = 0 ；此时 s = n，返回 n 即可。

//        int n=a^b;
//        int c=a&b<<1;
//        return n+c;

        int c=0;
        while (b!=0){ // 当进位为 0 时跳出
            c=(a&b)<<1;// c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;

    }

    @Test
    public void test(){
        int sum = add(3, 5);
        System.out.println(sum);
    }
}
