package offer;

/**
 * @ClassName offer52
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 11:25
 * @Version:1.0
 */
public class offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode l1=headA;
        ListNode l2=headB;
        while (l1!=l2){
            if (l1==null){
                l1=headB;
            }else{
                l1=l1.next;
            }
            if (l2==null){
                l2=headA;
            }else{
                l2=l2.next;
            }

        }
        return l1;

    }
}
