package wangyi;

import org.junit.Test;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        Map<Integer,Integer> weight=new HashMap<>();
        Map<Integer, List<Integer>> tree=new HashMap<>();
        int[] nums= new int[n];
        for (int i=0;i<n;++i){
            nums[i]=Integer.parseInt(sc.next());
        }
        for (int i=0;i<n-1;++i){
            int u=Integer.parseInt(sc.next());
            int v=Integer.parseInt(sc.next());
            weight.put(u,nums[u-1]);
            tree.getOrDefault(u,new ArrayList<>()).add(v);
            tree.getOrDefault(v,new ArrayList<>()).add(u);
        }
    }

    @Test
    public  void test(){
        final Student st=new Student();
        st.age=10;
        st.name="hello";

        st.age=90;

    }
}
class Student{
    int age;
    String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
