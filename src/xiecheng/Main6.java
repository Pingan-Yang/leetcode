package xiecheng;

import java.util.*;

public class Main6 {
    public  static int res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        String s=sc.nextLine();
        List<Tree> nodes=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Tree(i));
        }
        for (int i = 0; i < n-1; i++) {
            int u=Integer.parseInt(sc.next());
            int v=Integer.parseInt(sc.next());
            nodes.get(u-1).childs.add(nodes.get(v-1));
        }

        Map<Character,Integer> log=new HashMap<>();
        traverse(nodes.get(0),log);
        search(nodes.get(0),nodes.get(0).down);
        System.out.println(res);
    }



    private static Map<Character,Integer>  traverse(Tree tree, Map<Character, Integer> log) {
        if (tree==null){
            return log;
        }
        for (Tree c:tree.childs){
            Map<Character,Integer> d=new HashMap<>();
            d=traverse(c,log);
            int value1=log.get('r')+d.get('r');
            log.put('r',value1);
            int value2=log.get('g')+d.get('g');
            log.put('g',value2);
            int value3=log.get('b')+d.get('b');
            log.put('b',value1);
        }

       return null;
    }
    private static void search(Tree tree, Map<Character, Integer> down) {
    }
}

class Tree{
    int no;
    List<Tree> childs;
    Map<Character,Integer>down;

    public Tree(int no) {
        this.no=no;
        childs=new ArrayList<>();
        down=new HashMap<>();
    }
}
