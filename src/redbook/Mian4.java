package redbook;


import java.util.*;

/**
 * 某公司正在组织新员工团建，其中一项活动是两两配对进行石头剪刀布。
 *
 * 因为新员工来自不同的学校和专业，他们许多人之间并不熟悉，但他们之间的朋友关系形成了一棵树。
 * 即若将朋友关系描述为一张无向图，则这张无向图中任意两点之间有且仅有一条路径。
 * 为了避免尴尬，组织者希望互为朋友的配对数量尽可能多。现在他希望你求出互为朋友的配对数量最多能有多少。
 *
 *
 * 第一行有一个偶数n(2<=n<=1000)，代表有n个新员工。
 *
 * 第二行有n-1个空格隔开的数，第i个数ai代表编号为i+1的新员工与编号为ai的员工互为朋友。
 *
 * 输入保证新员工之间的朋友关系形成了一棵树
 */
public class Mian4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n-1];
        for (int i=0;i<n-1;++i){
            data[i]=sc.nextInt();
        }
        ArrayList<TreeSet<Integer>> vs=new ArrayList<>();

        for (int i=0;i<n-1;++i){
            if (vs.size()==0){
                TreeSet<Integer> set=new TreeSet<>();
                set.add(data[i]);
                set.add(i+2);
                vs.add(new TreeSet<>(set));
            }else{
                boolean flag=false;
                for (TreeSet<Integer> a :vs){

                }
            }
        }
    }
}
