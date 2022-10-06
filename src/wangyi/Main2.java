package wangyi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        int k=Integer.parseInt(sc.next());
        int x=Integer.parseInt(sc.next());
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(sc.next());
        }

        heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }


    public void heapSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //①：先将元素序列构成一个堆，这里选择大顶堆
        for (int i = 0; i < nums.length; ++i) {//O(N)
            insertHeap(nums, i);//O(logN)
        }
        int heapSize = nums.length;
        //②：交换大顶堆 头部与末尾一个数，同时大顶堆大小-1
        swap(nums, 0, --heapSize);
        //③：重新调整堆结构，使其满足大顶堆的定义
        while (heapSize > 0) {//O(N)
            heapify(nums, 0, heapSize);//O(logN)
            //4：调整完堆结构之后，继续交换大顶堆的头部与大顶堆末尾一个数
            swap(nums, 0, --heapSize);//O(1)
        }

    }


    public static void  heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            heapAdjust(arr, i, arr.length);
        }
        //System.out.println("第一次调整完的大顶堆:" + Arrays.toString(arr));

        //交换
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            heapAdjust(arr, 0, j);
            //System.out.println("XXXX大顶堆：" + Arrays.toString(arr));
        }

    }

    private static void heapAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        //j代表的是以i为节点的左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //找到该节点的叶子节点的最大值 j=i*2+1使i的左子节点
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;//指向右节点
            }
            if (arr[j] > temp) {//如果子节点>父节点 就把较大的值赋给父节点
                arr[i] = arr[j];
                i = j;//!!!i指向j循环比较
            } else {
                break;//因为对调整   从左到右，从下到上  不用担心接下来的子树问题
            }
        }
        //for循环结束后，我们已经将以i为父节点的树的最大值，放到了最顶（局部）
        arr[i] = temp;//将temp的值放到调整后的位置
    }

    //调整大顶堆结构-----就是某个数在index位置，能否往下移
    private static void heapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            //在index的左右子节点中，找到最大的数的下标
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            //父节点与孩子节点，谁的值大，就把下标给largest
            largest = nums[largest] > nums[index] ? largest : index;
            //largest与传进来的index相等，说明此时已经是大顶堆，则不用调整
            if (largest == index) {
                break;
            }
            //否则，将index位置的值与其子节点的最大值交换
            swap(nums, largest, index);
            //并且index下移到子节点,再次重复判断他与其左右节点的值
            index = largest;
            left = 2 * index + 1;
        }
    }


    private static void insertHeap(int[] arr, int index) {
        //找到当前节点的父节点，并比较大小，如果比当前节点的父节点大，则两者交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
