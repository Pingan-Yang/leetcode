package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName offer49
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/20 20:46
 * @Version:1.0
 */
public class offer49 {
    public int nthUglyNumber(int n) {
        // 丑数  x=2^a+3^b+5^c (a b c可以为0 )

        /**
         * 最小堆：
         *      初始时堆为空。首先将最小的丑数 1 加入堆。
         *      每次取出堆顶元素 x，则 x 是堆中最小的丑数
         *      由于 2x, 3x, 5x也是丑数，因此将 2x, 3x, 5x加入堆。
         *      上述做法会导致堆中出现重复元素的情况。
         *      为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
         *      在排除重复元素的情况下，第 n 次从最小堆中取出的元素即为第 n 个丑数。
         */

        int[] factors = {2, 3, 5};
        //要用Long类型  不然会报错
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; ++i) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (!set.contains(next)) {
                    heap.offer(next);
                }
                set.add(next);
            }
        }
        return ugly;

    }
}
