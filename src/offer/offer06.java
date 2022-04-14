package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName offer06
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/14 22:27
 * @Version:1.0
 */
public class offer06 {
    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[0];
        }
        Deque<Integer> stack=new ArrayDeque<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] ans=new int[stack.size()];
        int index=0;
        while (!stack.isEmpty()){
            ans[index++]=stack.pop();
        }

        return ans;

    }
}
