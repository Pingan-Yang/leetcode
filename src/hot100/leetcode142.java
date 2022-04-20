package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcode142
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 21:15
 * @Version:1.0
 */
public class leetcode142 {
    public ListNode detectCycle1(ListNode head){
        if (head==null||head.next==null){
            return null;
        }
        Set<ListNode>set=new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }

    /**
     * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，
     * 而 fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇
     * 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。
     * 起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
       while (fast!=null){
           slow=slow.next;
           if (fast.next!=null){
               fast=fast.next.next;
           }else{
               return null;
           }
           if (slow==fast){
               ListNode temp=head;
               while (temp!=slow){
                   temp=temp.next;
                   slow=slow.next;
               }
               return slow;
           }
       }
        return null;
    }
}
