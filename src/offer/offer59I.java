package offer;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName offer59I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 14:52
 * @Version:1.0
 */
public class offer59I {
    //执行用时：31 ms, 在所有 Java 提交中击败了13.44%的用户
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums==null||nums.length==0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <=n-k; ++i) {
            for (int j = i; j<i+k; ++j) {
                if (nums[j]>maxValue){
                    maxValue=nums[j];
                }
            }
            list.add(maxValue);
            maxValue=Integer.MIN_VALUE;
        }

       int[] ans=new int[list.size()];
        for (int i=0;i<list.size();++i){
            ans[i]=list.get(i);
        }
        return ans;
    }

    /**
     *
     * 优先队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums==null||nums.length==0){
            return new int[0];
        }
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>((o1,o2)->{
            //按照nums[i]的值从大到小进行排序，如果一样 按照小标从大到小排
            return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o2[1];
        });
        int n = nums.length;
        int[] ans=new int[n-k+1];
        //将前k个数入大根堆
        for (int i=0;i<k;++i){
            queue.offer(new int[]{nums[i],i});
        }
        //取出前k个数的最大值
        ans[0]=queue.peek()[0];

        for (int i=k;i<n;++i){
            //将当前数入堆
            queue.offer(new int[]{nums[i],i});
            //若当前大根堆的堆顶元素在滑动窗口左端，则移除
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            //取出当前滑动窗口最大值
            ans[i-k+1]=queue.peek()[0];
        }
        return ans;
    }

    /**
     *单调队列
     * 窗口对应的数据结构为 双端队列
     * deque 内 仅包含窗口内的元素 ⇒ 每轮窗口滑动移除了元素 nums[i−1] ，需将 deque 内的对应元素一起删除。
     * deque 内的元素 非严格递减 ⇒ 每轮窗口滑动添加了元素 nums[j+1] ，需将 deque 内所有 <nums[j+1] 的元素删除。
     *算法流程：
     * 初始化： 双端队列 deque ，结果列表 res ，数组长度 n ；
     * 滑动窗口： 左边界范围 i∈[1−k,n−k] ，右边界范围 j∈[0,n−1]
     * 若 i>0 且 队首元素 deque[0] == 被删除元素 nums[i−1] ：则队首元素出队；
     * 删除 deque 内所有 <nums[j] 的元素，以保持 deque递减；
     * 将 nums[j] 添加至 deque 尾部；
     * 若已形成窗口（即 i≥0 ）：将窗口最大值（即队首元素 deque[0] ）添加至列表 res ；

     */
    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums==null||nums.length==0){
            return new int[0];
        }
        Deque<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for (int j=0,i=1-k;j<nums.length;i++,j++){
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && queue.peekFirst() == nums[i - 1])
                queue.removeFirst();
            // 保持 deque 递减
            while(!queue.isEmpty() && queue.peekLast() < nums[j])
                queue.removeLast();
            queue.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = queue.peekFirst();
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] maxSlidingWindow = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }
}
