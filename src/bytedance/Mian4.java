package bytedance;

import java.util.Scanner;

public class Mian4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

    }

    public int jump(int[] nums) {
        //两步贪心--不仅要当前最优，下一次跳 也要最优
        int max_far=0;// 目前能跳到的最远位置
        int step=0;// 跳跃次数
        int end=0;// 上次跳跃可达范围右边界（下次的最右起跳点）
        for (int i=0;i<nums.length-1;++i){//为什么是nums.length-1 是因为，无法预知 最后一步跳到哪
            //我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了
            //如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素
            if (i+nums[i]>max_far){
                max_far=i+nums[i];
            }
            if (i==end){
                end=max_far;
                step++;
            }
        }
        return step;
    }
}
