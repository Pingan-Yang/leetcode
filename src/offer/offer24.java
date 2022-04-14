package offer;

/**
 * @ClassName offer24
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/14 22:34
 * @Version:1.0
 */
public class offer24 {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode temp=new ListNode();
        ListNode next;
        while (head!=null){
            next=head.next;
            head.next=temp.next;
            temp.next=head;
            head=next;
        }
        return temp.next;
    }
}
