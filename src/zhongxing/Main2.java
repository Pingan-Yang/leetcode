package zhongxing;

import org.junit.Test;

import java.util.Arrays;

public class Main2 {
    public int[][] snake_matrix(int n){
        int[][] arr=new int[n][n];
        int x=0,y=0;
        int num=arr[0][0]=1;
        while(num<n*n){
            //左上到左下
            while(x+1<n&&arr[x+1][y]==0){
                arr[++x][y]=++num;
            }
            //左下到右下
            while(y+1<n&&arr[x][y+1]==0){
                arr[x][++y]=++num;
            }

            //右下到右上
            while(x-1>=0&&arr[x-1][y]==0){
                arr[--x][y]=++num;
            }


            //右上到左上
            while(y-1>=0&&arr[x][y-1]==0){
                arr[x][--y]=++num;
            }
        }
        //输出
//        for (int[] nums:arr){
//            System.out.println(Arrays.toString(nums));
//        }
        return arr;
    }

    @Test
    public void test(){
        int n=3;
        System.out.println(snake_matrix(n));
    }
}
