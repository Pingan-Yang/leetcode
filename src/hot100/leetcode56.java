package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode56
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/10 21:40
 * @Version:1.0
 */
public class leetcode56 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length==1){
            return intervals;
        }
        List<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,(int[]o1,int[]o2)->{
            return o1[0]-o2[0];
        });

        for (int i=0;i<intervals.length;++i){
            int l=intervals[i][0];
            int r=intervals[i][1];

            if (list.size()==0||list.get(list.size()-1)[1]<l){
                // 如果当前数组的左边界>上一个数据的右边界 说明没重复 直接添加即可
                list.add(new int[]{l,r});
            }else{
                // 如果当前数组的左边界<上一个数据的右边界 说明重复  更新上一个数组的右边界即可
                list.get(list.size()-1)[1]=r;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void test(){
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for (int i=0;i<merge.length;++i){
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
