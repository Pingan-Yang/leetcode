package xiecheng;

import java.util.*;

public class Main3 {
    //树是不含重边和自环的无向连接图
    static int ans=0;
    static  HashSet<Character> set1=new HashSet<>();
    static  HashSet<Character> set2=new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        visited=new boolean[n];
        String str=sc.next();
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i=0;i<n-1;++i){
            int u=Integer.parseInt(sc.next());
            int v=Integer.parseInt(sc.next());
            if (!map.containsKey(u)){
                List<Integer>list=new ArrayList<>();
                list.add(v);
                map.put(u,new ArrayList<Integer>(list));
            }else{
                map.get(u).add(v);
            }

            if (!map.containsKey(v)){
                List<Integer>list=new ArrayList<>();
                list.add(u);
                map.put(v,new ArrayList<Integer>(list));
            }else{
                map.get(v).add(u);
            }
        }

        process(str,map);
    }

    private static void process(String str, Map<Integer, List<Integer>> map) {
        set1.add('r');
        set1.add('g');
        set1.add('b');

        set2.add('r');set2.add('g');set2.add('b');
       dfs(str,map,1);
    }

    private static void dfs(String str, Map<Integer, List<Integer>> map, int i) {
        //
    }
}
