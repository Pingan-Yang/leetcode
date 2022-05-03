package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName offer40
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 9:33
 * @Version:1.0
 */
public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        //建立一个大根堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }

        return res;
    }

    @Test
    public void test() {
        int[] arr = {4, 2, 1, 3};
        int k = 2;
        int[] leastNumbers = getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
