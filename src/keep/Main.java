package keep;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.*;

public class Main {

    public int[] process(int[][] queries) {
        List<Integer> ans=new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int[] nums : queries) {
            if (nums[0] == 1) {
                deque.addLast(nums[1]);
            } else if (nums[0] == 2) {
                deque.addFirst(nums[1]);
            } else {
                int l=0;
                int r=deque.size()-1;
                Iterator<Integer> iterator = deque.iterator();
                int index=0;
                while(iterator.hasNext()){
                    int date=iterator.next();
                    if (date==nums[1]){
                        ans.add(Math.min(index-l,r-index));
                    }
                    index++;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test(){
       // int[][] queries={{1,1},{2,2},{2,3},{0,2},{1,4},{0,1},{1,5},{0,1}};
        int[][] queries={{1,100},{2,100000},{2,123},{1,101},{0,123},{1,10},{2,115},{0,100},{2,110},{0,115}};
        int[] ans = process(queries);
        System.out.println(Arrays.toString(ans));
    }
}
