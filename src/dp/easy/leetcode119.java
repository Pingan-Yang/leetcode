package dp.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode119
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/8 20:47
 * @Version:1.0
 */
public class leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            Integer[] array = new Integer[i + 1];
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    array[j] = 1;
                } else {
                    array[j] = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                }
            }
            res.add(new ArrayList<Integer>(Arrays.asList(array)));
        }
        return res.get(rowIndex);
    }

    @Test
    public void test() {
        List<Integer> row = getRow(0);
        System.out.println(row);
    }
}
