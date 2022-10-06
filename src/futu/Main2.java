package futu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long[] nums = new Long[Integer.parseInt(n + "")];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);
        int ans = process(nums);
        System.out.println(ans);

    }

    private static int process(Long[] nums) {
        int i = 1;
        for (; i < nums.length; ++i) {
            if (nums[i - 1] + 1 == nums[i]) {
                continue;
            } else {
                break;
            }
        }
        if (i == nums.length) {
            return 0;
        }
        int ans=0;

        HashMap<String,Long[]> map= new HashMap<>();

        for (i=0;i<nums.length;++i){
           int start=i;
           int j=start;
           for (;j<nums.length-1;++j){
               if (nums[j]+1==nums[j+1]){
                   continue;
               }else {
                   map.put(i + " " + j, new Long[]{nums[start], nums[j]});
                   break;
               }
           }
           i=j;
        }

//        for (Map.Entry<String,Long[]> entry:map.entrySet()){
//            String[] index = entry.getKey().split(" ");
//            int start=Integer.parseInt(index[0]);
//            int end=Integer.parseInt(index[1]);
//
//        }


        return ans;
    }
}
