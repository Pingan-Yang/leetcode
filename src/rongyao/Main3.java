package rongyao;

import java.util.*;

/**
 * @ClassName Main3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 19:23
 * @Version:1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        str = str.replace('+', ' ').replace(',', ' ');
        String[] stringValue = str.split(" ");
        int[] value=new int[stringValue.length];
        int index=0;
        for (String s:stringValue) {
            value[index++]=Integer.valueOf(s);
        }
        //-------------------------------
        Arrays.sort(value);

        process(value);
    }

    private static void process(int[] value) {
        int n=value.length;
        int col=1;
         for (int i=1;i<n-1;++i){
             if (value[i]*2!=value[i-1]+value[i+1]) break;
             col++;
         }
         col++;

         int row=n/2;
         int[][] res=new int[row][col];

         int index=0;

         for (int i=0;i<row;i++){
             for (int j=0;i<col;++j){
                 res[i][j]=value[index++];
             }
         }
        System.out.println("length:"+col);
         for (int[] re:res){
             System.out.println(Arrays.toString(re));
         }
    }
}
