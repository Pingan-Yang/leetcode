package hot100;

/**
 * @ClassName leetcode121
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 20:54
 * @Version:1.0
 */
public class leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices.length<1){
            return 0;
        }

        int maxProfit=0;
        int minPrice=prices[0];
        for (int i=1;i<prices.length;++i){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }
            if (prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
