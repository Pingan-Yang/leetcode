package yaxin;

public class Solution3 {
    public static void main(String[] args) {
        long ans=countPatient(15);
        System.out.println(ans);
    }
    public static long countPatient (int days) {
        // write code here
        if (days<6){
            return 1;
        }
        long[] nums=new long[days+1];
        for (int i=1;i<=6;++i){
            nums[i]=1;
        }
        if (days<14){
            for (int i=7;i<days+1;++i){
                nums[i]=nums[i-1]+3*nums[i-6];
            }
        }else{
            for (int i=7;i<14;++i){
                nums[i]=nums[i-1]+3*nums[i-6];
            }
            for (int i=14;i<days+1;++i){
                nums[i]=nums[i-1]+3*nums[i-6]-nums[i-13];
            }
        }


        return nums[days];
    }
}
