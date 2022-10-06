package zhongjinsuo;

import org.junit.Test;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[7];
        for (int i = 0; i <7; i++) {
            prices[i]=sc.nextInt();
        }
        int ans = maxProfit(prices);
        System.out.println(ans);

    }

    public static  int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int dp0=0;
        int dp1=-prices[0];

        for (int i = 1; i < n; ++i) {
            int newdp0=Math.max(dp0,dp1+prices[i]);
            int newdp1=Math.max(dp1,dp0-prices[i]);
            dp0=newdp0;
            dp1=newdp1;
        }
        return Math.max(dp0,dp1);
    }


    public int  firstUniqChar(String s) {
        if (s==null||s.length()==0){
            return -1;
        }
        Set<Character> set=new HashSet<>();
        List<Character> res=new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (!set.contains(c)){
                set.add(c);
                res.add(c);
            }else{
                res.remove(new Character(c));
            }

        }
        return res.size()==0?-1:s.indexOf(res.get(0));
    }

    @Test
    public void test(){
        String s="google";
        System.out.println(firstUniqChar(s));
    }
}
