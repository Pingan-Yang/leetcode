package shunfeng;

import org.junit.Test;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int m=Integer.parseInt(sc.next());
        int[][] nums=new int[m][3];
        for (int i=0;i<m;++i){
            for (int j=0;j<3;++j){
                nums[i][j]=Integer.parseInt(sc.next());
            }
        }
        process(n,nums);
    }

    private static void process(int total, int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        Arrays.sort(nums,(o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        boolean[] flags=new boolean[total];
        List<int[]> list=new ArrayList<>();
        for (int[] num:nums){
            for (int i=num[0]-1;i<=num[1]-1;++i){
                flags[i]=true;
            }
            int l=num[0]-1;
            int r=num[1]-1;
            int x=num[2];
            if (!list.isEmpty()){
                int[] prev = list.get(list.size() - 1);
                if (prev[1]<l){
                    list.add(new int[]{l,r,x});
                }else{
                   if (prev[1]>=r){
                       x=Math.min(prev[1]-prev[0]+1,x+prev[2]);
                   }else{
                       x=Math.min(r-prev[0]+1,x+prev[2]);
                       prev[1]=r;
                   }
                    prev[2]=x;
                    list.remove(list.size()-1);
                    list.add(new int[]{prev[0],prev[1],prev[2]});
                }
            }else{
                 list.add(new int[]{l,r,x});
            }
        }
        int count=0;
        for (int i=1;i<=total;++i){
            if (!flags[i-1]){
                count++;
            }
        }
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()){
            int[] data = iterator.next();
            count+=data[2];
        }
        System.out.println(count);
    }

//    @Test
//    public void test(){
//        int a=0,b=0,c=0;
//        c=(a-=a-5),(a=b,b+3);
//
//    }
}
