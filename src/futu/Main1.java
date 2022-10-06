package futu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;++i){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int ans=process(nums);
        System.out.println(ans);
    }

    private static int process(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int ans=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int count=entry.getValue();
            if (map.containsKey(entry.getKey()+1)){
                count+=map.get(entry.getKey()+1);
            }
            if(map.containsKey(entry.getKey()-1)){
                count+=map.get(entry.getKey()-1);
            }

            ans=Math.max(ans,count);
        }
        return ans;

    }
}
