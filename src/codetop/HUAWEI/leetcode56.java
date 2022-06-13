package codetop.HUAWEI;

/**
 * @ClassName leetcode56
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 21:40
 * @Version:1.0
 */


import org.junit.Test;
import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并区间：
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，
 * 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        //按照开始点从大到小排序
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        });

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] arr : intervals) {
            if (!list.isEmpty()) {
                if (arr[0] > list.getLast()[1]) {
                    list.add(new int[]{arr[0], arr[1]});
                } else if (arr[0] <= list.getLast()[1]) {
                    if (arr[1] > list.getLast()[1]) {
                        list.getLast()[1] = arr[1];
                    }
                }
            } else {
                list.add(new int[]{arr[0], arr[1]});
            }
        }

//        int[][] ans = new int[list.size()][];
//        int index = 0;
//        for (int[] arr : list) {
//            ans[index] = new int[]{arr[0], arr[1]};
//            index++;
//        }
//        return ans;

        //更优雅的写法
        return list.toArray(new int[list.size()][]);

    }

    @Test
    public void test() {
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; ++i) {
            System.out.println(Arrays.toString(merge[i]));
        }

    }
}
