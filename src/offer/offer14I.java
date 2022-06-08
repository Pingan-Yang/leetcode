package offer;

/**
 * @ClassName offer14I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/8 20:33
 * @Version:1.0
 */
public class offer14I {

    /**
     *设将长度为 n 的绳子切为 a 段： n=n1+n2+...+na;
     * 等价于求解 max(n1*n2*...*na);
     * ① 当所有绳段长度相等时，乘积最大
     * ② 最优的绳段长度为 3
     *
     * 推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。(算术几何平均不等式)
     * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。（求导）
     *
     * 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2三种情况。
     * 次优： 2。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1。
     * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1替换为 2 + 2，因为 2×2>3×1。
     * 算法流程：
     * 当 n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1段，因此必须剪出一段长度为 1的绳子，即返回 n - 1。
     * 当 n>3 时，求 n 除以 3 的 整数部分 a 和 余数部分 b （即 n = 3a + b ），并分为以下三种情况
     * 当 b = 0b=0 时，直接返回 3^a
       当 b = 1 时，要将一个 1 + 3转换为 2+2，因此返回 3^{a-1} *4
       当 b = 2 时，返回 3^a *2


     *
     */
    public int cuttingRope(int n) {

        if (n<=3){
            return n-1;
        }
        int a=n/3;
        int b=n%3;
        if (b==0){
            return (int) Math.pow(3,a);
        }else if (b==1){
            return (int)Math.pow(3,a-1)*4;
        }else{
            return (int)Math.pow(3,a)*2;
        }

    }
}
