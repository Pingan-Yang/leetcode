package HUAWEI;

import java.util.Scanner;

public class Main2 {
    public static int ulres=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=Integer.parseInt(sc.next());
        int n=Integer.parseInt(sc.next());
        int[][] matrix=new int[m][n];
        int[][] label=new int[m][n];
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                matrix[i][j]=Integer.parseInt(sc.next());
                label[i][j]=matrix[i][j];

            }
        }
        //=======================
        int res=0;
        int px=0,py=0;
        dfs(label,res,px,py);
        System.out.println(ulres);
    }

    private static void dfs(int[][] label, Integer res,int px, int py) {
      for (int i=px;i<=label.length;++i){
          if (i==label.length){
              ulres=Math.max(ulres,res);
              return;
          }
          for (int j=py;j<label[0].length;j++){
              py=0;
              if (okpos(label,i,j)){
                  res++;
                  label[i][j]=1;
                  int curpos=i*label[0].length+1;
                  dfs(label,res,curpos/label[0].length,curpos%label[0].length);
                  res--;
                  label[i][j]=0;
              }
          }
      }
    }

    public  static  boolean okpos(int[][]label ,int x,int y){
        if (label[x][y]==1){
            return false;
        }
        if (x>0){
            if (label[x-1][y]==1) return false;
        }
        if (x<label.length-1){
            if (label[x+1][y]==1) return  false;
        }
        if (y>0){
            if (label[x][y-1]==1) return false;
        }
        if (y<label[0].length-1){
            if (label[x][y+1]==1) return  false;
        }
        return true;
    }

}
