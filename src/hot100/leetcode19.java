package hot100;

/**
 * @ClassName leetcode19
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/5 19:48
 * @Version:1.0
 */
public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        if (n==len){
            return head.next;
        }
        cur=head;
        for (int i=0;i<len-n-1;++i){
            cur=cur.next;
        }
        if (cur.next.next!=null){
            cur.next=cur.next.next;
        }else{
            cur.next=null;
        }
        return head;
    }
}
