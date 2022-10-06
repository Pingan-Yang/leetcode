package HUAWEI;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Scanner;

public class Main3 {
    static int[] dx={-1,1,0,0};
    static  int[] dy={0,0,1,-1};
    static boolean visited[][];
    static int cnt=0;
    static int maxCount=2;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=Integer.parseInt(sc.next());
        int n=Integer.parseInt(sc.next());
        int[][] nums=new int[m][n];
        visited=new boolean[m][n];
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                nums[i][j]=Integer.parseInt(sc.next());
            }
        }

        //---------
        int max=0;
        boolean flage=false;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (nums[i][j]==0&&maxCount>0){
                    maxCount--;
                    nums[i][j]=1;
                    flage=true;
                }
                if (nums[i][j]!=0&&!visited[i][j]){
                    cnt=0;
                    dfs(i,j,nums);
                    if (cnt>max){
                        max=cnt;
                    }
                    if (flage==true){
                        maxCount++;
                        flage=false;
                        nums[i][j]=0;
                        visited[i][j]=false;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y,int[][]nums) {
        cnt++;
        visited[x][y]=true;
        int m=nums.length;
        int n=nums[0].length;
        boolean flag=false;
        for (int i=0;i<4;++i){
            int newX=dx[i]+x;
            int newY=dy[i]+y;
            if(newX<m&&newX>=0&&newY<n&&newY>=0) {
                if (nums[newX][newY]==0&&maxCount>0){
                    maxCount--;
                    nums[newX][newY]=1;
                    flag=true;
                }
                if (nums[newX][newY] != 0 && visited[newX][newY]) {
                    dfs(newX, newY, nums);
                }

                if (flag){
                    flag=false;
                    nums[newX][newY]=0;
                    maxCount++;
                }
            }
        }
    }
}
