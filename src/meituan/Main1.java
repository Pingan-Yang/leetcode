package meituan;


import java.util.*;

/**
 * @ClassName Main1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/13 16:06
 * @Version:1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        int[] arr=new int[n];
        for (int i=0;i<n;++i){
            arr[i]=Integer.parseInt(sc.next());
        }

        //i<j<k
        int ans=0;
        for (int i=0;i<n-2;++i){
            for (int j=i+1;j<n-1;++j){
                for (int k=j+1;k<n;++k){
                    if (arr[i]+arr[k]==3*arr[j]){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
