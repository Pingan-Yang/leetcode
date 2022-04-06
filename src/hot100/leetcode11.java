package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode11
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/30 21:22
 * @Version:1.0
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        if (height.length==2){
            return Math.min(height[0],height[1]);
        }

        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;

    }
    @Test
    public void test(){
        int[] height={1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }

}
