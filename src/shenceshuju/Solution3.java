package shenceshuju;

/**
 * @ClassName Solution3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/19 18:41
 * @Version:1.0
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{998,570,876,200,877}));
    }

    public static int  solution(int[] arr){
        int ans=0;
        int n=arr.length;
        for (int i=0;i<n;++i){
            for (int j=0;j<n&&i!=j;++j){
                ans=Math.max(arr[i]+arr[j]-Math.abs(j-i), ans);
            }
        }
        return ans;
    }
}
