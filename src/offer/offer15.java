package offer;

import org.junit.Test;

/**
 * @ClassName offer15
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/4 22:22
 * @Version:1.0
 */
public class offer15 {
    public int hammingWeight(int n) {

        int res=0;
        //这里的条件写n>0 会不过 要写n！=0
        while (n>0){
            res+=n&1;
            n>>>=1;

        }
        return res;


    }

    @Test
    public void test(){
        int i = hammingWeight(Integer.MAX_VALUE-1);
        System.out.println(i);
    }
}
