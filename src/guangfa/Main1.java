package guangfa;

import org.junit.Test;

public class Main1 {
    public boolean isPalindromeBit (int n) {
        // write code here

        if(n==0){
            return true;
        }

        String str = Integer.toBinaryString(n);

        int len=str.length();

        for (int i=0,j=len-1;i<=j;++i,--j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;

    }

    @Test
    public void test(){
        int n=6;
        boolean ans = isPalindromeBit(n);
        System.out.println(ans);
    }
}
