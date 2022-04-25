package offer;

import org.junit.Test;

/**
 * @ClassName offer46
 * @Description:
 * @Author 15368
 * @Date 2022/4/22 15:13
 * @Version:1.0
 */
public class offer46 {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        //dp[i]:表示以Xi结尾的数字的翻译方案的数量
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < str.length(); ++i) {
            if ((str.charAt(i - 1) == '1' &&(str.charAt(i) <= '9'))||(( str.charAt(i - 1) == '2') && str.charAt(i) <= '5') ){
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    @Test
    public void test(){
        int num=18580;
        int i = translateNum(num);
        System.out.println(i);
    }
}
