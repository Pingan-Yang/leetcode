package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName offer57II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/8 20:45
 * @Version:1.0
 */
public class offer57II {
    List<int[]> res=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public int[][] findContinuousSequence1(int target) {

        for (int i=1;i<target/2+1;++i){
            dfs(i,0,0,target);
        }

       // System.out.println(res);
        return res.toArray(new int[0][]);
    }
    // start：开始的数，step: 走的步数acc: 累加所得 target:目标值
    private void dfs(int start,int step,int acc,int target){
        //终止条件
        //如果累加超过目标值，那么就退出
        if (acc>target){
            return;
        }
        //如果累加等于目标值，那么生成数组并添加到结果
        // step > 0 保证至少数组含有两个数
        if (acc==target&&step>0){
            for (int i=0;i<step;++i){
                list.add(start+i);
            }
            int[] array = list.stream().mapToInt(Integer::intValue).toArray();
            res.add(array);
            list.clear();
        }

        dfs(start,step+1, acc+start+step, target);
    }

    //滑动窗口，双指针法

    /**
     * 设连续正整数序列的左边界 i 和右边界 j ，则可构建滑动窗口从左向右滑动。
     * 循环中，每轮判断滑动窗口内元素和与目标值 target的大小关系，若相等则记录结果，
     * 若大于 target则移动左边界 i （以减小窗口内的元素和），
     * 若小于 target则移动右边界 j （以增大窗口内的元素和）
     */
    public int[][] findContinuousSequence(int target) {

        int i=1;
        int j=2;
        int s=3;
        List<int[]> res = new ArrayList<>();
        while (i<j){
            if (s==target){
                int[] ans=new int[j-i+1];
                for (int k=i;k<=j;++k){
                    ans[k-i]=k;
                }
                res.add(ans);
            }
            if (s>target){
                s-=i;
                i++;
            }else{
                j++;
                s+=j;
            }
        }
        return res.toArray(new int[0][]);
    }

    @Test
    public void test(){
        int target=15;
        int[][] ints = findContinuousSequence(target);
        for (int[] arr:ints){
            System.out.println(Arrays.toString(arr));
        }
    }
}
