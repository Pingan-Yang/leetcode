package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName offer45
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/28 19:51
 * @Version:1.0
 */
public class offer45 {
    public String minNumber1(int[] nums) {
        // 看的解答
        // 本质是一个字符串排 序问题：设数组 nums中任意两数字的字符串为 x和 y ，
        // 若拼接字符串 x + y > y + x，则 x “大于” y ；
        // 反之，若 x + y < y + x ，则 x “小于” y ；
        // x “小于” y 代表：排序完成后，数组中 x应在 y 左边；“大于” 则反之。

        if (nums==null||nums.length==0){
            return null;
        }
        String[] ss=new String[nums.length];
        for (int i=0;i<nums.length;++i){
            ss[i]=String.valueOf(nums[i]);
        }

        //进行字符串排序
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<ss.length;++i){
            sb.append(ss[i]);
        }
        return sb.toString();
    }

    //快排
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();

    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }


    @Test
    public void test(){
        int[] nums={3,30,34,5,9};
        String s = minNumber1(nums);
        System.out.println(s);
    }
}
