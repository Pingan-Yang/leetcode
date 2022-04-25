package offer;

/**
 * @ClassName offer18
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 10:59
 * @Version:1.0
 */
public class offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val){
            head=head.next;
            return head;
        }
        ListNode cur=head;
        while (cur.next!=null){
            if (cur.next.val==val){
                if (cur.next.next!=null){
                    cur.next=cur.next.next;
                    break;
                }else{
                    cur.next=null;
                    break;
                }
            }
            cur=cur.next;
        }
        return head;
    }
}
