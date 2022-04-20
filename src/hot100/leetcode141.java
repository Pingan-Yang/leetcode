package hot100;


import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcode141
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 20:41
 * @Version:1.0
 */
public class leetcode141 {
    public boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }

        return false;
    }
    //O（1）空间复杂度
    public boolean hasCycle(ListNode head){
        if (head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=slow){
            if (fast==null||fast.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return true;
    }
}
