package hot100;

/**
 * @ClassName leetcode160
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 21:36
 * @Version:1.0
 */
public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headA==null){
            return null;
        }
        ListNode p=headA;
        ListNode q=headB;
        while (p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }
        return p;
    }
}
