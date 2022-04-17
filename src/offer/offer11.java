package offer;

import org.junit.Test;

import java.lang.reflect.Member;

/**
 * @ClassName offer11
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 21:59
 * @Version:1.0
 */
public class offer11 {
    public int minArray(int[] numbers) {
        /**
         *  这里其实是两段有序数组，且第一个有序数组的头一定>=第二个有序数组的尾
         *         因此  可以用二分法，快速跳过第一段有序数组
         *         这里的难点是有相等的元素。
         *         如果中间值==右边界的值 怎么办？
         *         假设此时是最小值，那么即使删了有边界的值也一定可以找到最小治，因为中间值和它相等
         *         所以 此时右边界左移1位
         *
         *         时间复杂度最好logN，最差N
         *         空间复杂度1
         */
        if (numbers.length==1){
            return numbers[0];
        }
        int l=0;
        int r=numbers.length-1;
        while (l<r){
           int mid=(l+r)/2;
           if (numbers[mid]>numbers[r]){
               //表明mid在第一段有序数组上，因此，最小值肯定在mid的右边
               l=mid+1;
           }else if(numbers[mid]<numbers[r]){
               //则表明此时应该在第二段有序数组上，且最小值应该在<=mid的左边
               r=mid;
           }else{
               //相等，则此时抛去右边界，选择一个新的右边界
               r--;
           }
        }
        return numbers[r];
    }

    @Test
    public void test(){
        int[] number={2,2,2,0,1};
        int i = minArray(number);
        System.out.println(i);
    }
}
