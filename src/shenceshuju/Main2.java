package shenceshuju;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/22 20:45
 * @Version:1.0
 */

/**
 * 4
 * 2 1
 * 3 1
 * 4 2
 * 5 3
 * 4 5
 */
public class Main2 {
    static Map<Integer, List<Integer>> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        for (int i=0;i<n;++i){
            int a= Integer.parseInt(sc.next());
            int b= Integer.parseInt(sc.next());
            if (!map.containsKey(b)){
                map.put(b,new ArrayList<>());
            }
            map.get(b).add(a);
        }

        int x= Integer.parseInt(sc.next());
        int y= Integer.parseInt(sc.next());

        if (x==1||y==1){
            System.out.println(1);
        }else{
            //dfs
            List<Integer> dfs = dfs(x, y, 1);
            int[] res = getRes(dfs);
            if(res[0]>1){
                System.out.println(1);
            }else{
                System.out.println(res[1]);
            }
        }
    }

    private static  List<Integer> dfs(int x,int y,int s){
        List<Integer> list = map.get(s);
        List<Integer> res=new ArrayList<>();
        for (int city:list){
            if (x==city||y==city){
                res.add(city);
                continue;
            }
            if (!map.containsKey(city)){
                res.add(-1);
            }else {
               List<Integer>dfs= dfs(x,y,city);
                int[] temp = getRes(dfs);
                if (temp[0]>1)
                    res.add(city);
                else
                    res.add(temp[1]);

            }
        }
        return res;
    }


    private static int[] getRes(List<Integer> dfs){
        int num=0;
        int val=-1;
        for (int t:dfs){
            if (t>0){
                num++;
                val=t;
            }
        }
        return  new int[]{num,val};
    }
}
