package offer;

/**
 * @ClassName offer63
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 19:43
 * @Version:1.0
 */
public class offer63 {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<2){
            return 0;
        }
        int maxProfit=0;
        int minPrice=prices[0];
        for (int i=1;i<prices.length;++i){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
