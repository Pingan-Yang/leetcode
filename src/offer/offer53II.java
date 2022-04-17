package offer;

import org.junit.Test;

import java.util.logging.Level;

/**
 * @ClassName offer53II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/17 21:40
 * @Version:1.0
 */
public class offer53II {
    public int missingNumber1(int[] nums) {
        int i=0;
        for (;i<nums.length;++i){
            if (nums[i]!=i){
                break;
            }
        }
        return i;
    }

    /**
     * 二分法：
     * 左子数组nums[l]==l;
     * 右子数组nums[r]!≠r;
     * 缺失的数字等于 “右子数组的首位元素” 对应的索引
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==mid){//右子数组的开始位置一定在[mid+1,r]
                l=mid+1;
            }else{//左子数组的末尾一定在[l,mid-1]
                r=mid-1;
            }
        }
        // 跳出时，变量 l 和 r 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。
        return l;
    }
    @Test
    public void test(){
        int[] nums={0,1,2,3,4,5,6,7,9};
        int i = missingNumber(nums);
        System.out.println(i);
    }
}
