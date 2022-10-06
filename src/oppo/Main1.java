package oppo;

import org.junit.Test;

import java.util.Arrays;

public class Main1 {
    public int maxDigit (int[] digits) {
        // write code here
       Arrays.sort(digits);
       if (digits[digits.length-1]==0){
           return 0;
       }
       StringBuilder sb=new StringBuilder();
       for (int i=0;i<digits.length;++i){
           sb.append(digits[i]);
       }
       return Integer.parseInt(sb.reverse().toString());
    }

    @Test
    public void test(){
        int[] nums={3,4};
        int digit = maxDigit(nums);
        System.out.println(digit);
    }
}
