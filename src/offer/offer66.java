package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName offer66
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/5 20:33
 * @Version:1.0
 */
public class offer66 {
    //暴力法-----O(N^2)会超时
    public int[] constructArr1(int[] a) {
        if (a==null||a.length==0){
            return new int[0];
        }
        int n=a.length;
        int [] b=new int[n];
        Arrays.fill(b,1);
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                if (i==j){
                    continue;
                }
                b[i]*=a[j];
            }
        }
        return b;
    }

    // 表格分区：上三角和下三角
    public int[] constructArr(int[] a){
        if (a==null||a.length==0){
            return new int[0];
        }
        int n=a.length;
        int [] b=new int[n];
        b[0]=1;

        //计算下三角的值（从上到下）
        for (int i=1;i<n;++i){
            b[i]=b[i-1]*a[i-1];
        }
        int temp=1;
        //计算上三角的值（从下到上）
        for (int i=n-2;i>=0;i--){
            temp*=a[i+1];
            b[i]*=temp;
        }
        return b;
    }

    @Test
    public void test(){
        int[] a={1,2,3,4,5};
        int[] arr = constructArr(a);
        System.out.println(Arrays.toString(arr));
    }

}
