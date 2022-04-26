package hot100;

/**
 * @ClassName leetcode147
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/26 21:02
 * @Version:1.0
 */
public class leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newHead=new ListNode();
        newHead.next=head;
        ListNode lastedSort=head;
        ListNode cur=head.next;
        while (cur!=null){
            if (cur.val>=lastedSort.val){
                lastedSort=cur;
            }else{
                ListNode prev=newHead;
                while (prev.next.val<cur.val){
                    prev=prev.next;
                }
                lastedSort.next=cur.next;
                cur.next=prev.next;
                prev.next=cur;
            }
            cur=lastedSort.next;
        }
        return newHead.next;

    }
}
