package weizhong;


import java.util.*;

/**
 * 桌面上有n张卡片，每张卡片上都写有一个正整数，现在你可以从中选出三张卡片，将卡片上的三个数按任意顺序连接成一个新的数。
 * 例如，对于三个数字123、45、678，你可以将它们连成12345678、45123678、67845123、67812345或12367845等，可以证明67845123是能拼接出的最大的数。
 * 注意，对于卡片上的数字，你不能将其拆开。
 *
 * 第一行是一个正整数n，表示有n张卡片。
 *
 * 第二行是n个用空格隔开的正整数，其中第i个数a_i表示第i张卡片上写的数字。保证数字不含前导零。
 *
 * 一行一个整数，表示能拼接出的最大的数。
 */
public class Main1 {
    static boolean[] visted;
    static StringBuilder sb=new StringBuilder();
    static List<Long> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        Long[] nums=new Long[n];
        visted=new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Long.parseLong(sc.next());
        }
        Arrays.sort(nums);
        dfs(nums,0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list);
    }

    private static void dfs(Long[] nums, int deepth) {
        if (deepth==3){
            list.add(Long.parseLong(sb.toString()));
            return;
        }
        for (int i=0;i<nums.length;++i){
            if ((visted[i]||(i>0&&nums[i]==nums[i-1])&&!visted[i])){
                continue;
            }
            int len=(nums[i]+"").length();
            sb.append(nums[i]);
            visted[i]=true;
            dfs(nums,deepth+1);
            visted[i]=false;
            sb.delete(sb.length()-len,sb.length());

        }
    }
}
