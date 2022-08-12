package hot100;

/**
 * @ClassName leetcode4
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/9 16:05
 * @Version:1.0
 */

import org.junit.Test;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 */
public class leetcode4 {
    /**
     * 暴力法：直接将两个有序数组，合成一个有序数组
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int[] arrays=new int[m+n];

        if (m==0){
            if (n%2==0){
                return (double)(nums2[n/2-1]+nums2[n/2])/2;
            }else{
                return (double)nums2[n/2]/1.000000;
            }
        }

        if (n==0){
            if (m%2==0){
                return (nums1[m/2-1]+nums1[m/2])/2.0;
            }else{
                return nums1[m/2];
            }
        }

        int i=0,j=0,count=0;
        while (count!=(m+n)){
            if (i==m){
                while (j!=n){
                    arrays[count++]=nums2[j++];
                }
                break;
            }

            if (j==n){
                while (i!=m){
                    arrays[count++]=nums1[i++];
                }
                break;
            }

            if (nums1[i]<nums2[j]){
                arrays[count++]=nums1[i++];
            }else{
                arrays[count++]=nums2[j++];
            }
        }

        if ((m+n)%2==0){
            return (arrays[(m+n)/2-1]+arrays[(m+n)/2])/2.0;
        }

        return arrays[(m+n)/2];
    }

    @Test
    public void test(){
        int[] nums1={1,2};
        int[] nums2={3,4};
        double val = findMedianSortedArrays(nums1, nums2);
        System.out.println(val);
    }
}
