package offer;

import org.junit.Test;

/**
 * @ClassName offer56II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/5 10:53
 * @Version:1.0
 */
public class offer56II {
    public int singleNumber(int[] nums) {

        //考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
        //因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。

        int[] bits = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; ++j) {
                bits[j] += num & 1;
                num >>>= 1;//无符号右移
            }
        }

        int res = 0;
        int mod = 3;

        for (int i = 0; i < 32; ++i) {
            res <<= 1;
            res |= bits[31 - i] % mod;
//            res |= bits[i] % mod;//536870912
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums={3,4,3,3};
        int number = singleNumber(nums);
        System.out.println(number);
    }
}

