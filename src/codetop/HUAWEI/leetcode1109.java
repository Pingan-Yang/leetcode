package codetop.HUAWEI;

/**
 * @ClassName leetcode1109
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/4 21:08
 * @Version:1.0
 */

import org.junit.Test;

import java.util.*;

/**
 * 1109. 航班预订统计
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 */
public class leetcode1109 {

    /**
     *记录不了 1,2,的顺序
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        Map<Integer,Integer> map=new TreeMap<>();
        for (int[] nums:bookings){
            for (int i=nums[0];i<=nums[1];++i){
                if (!map.containsKey(i)){
                    map.put(i,nums[2]);
                }else{
                    map.put(i,map.get(i)+nums[2]);
                }
            }
        }
        int[] ans=new int[n];
        int i=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans[i++]=entry.getValue();
        }
        return ans;
    }


    public int[] corpFlightBookings(int[][] bookings, int n){
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
