package offer;

/**
 * @ClassName offer22
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 11:04
 * @Version:1.0
 */
public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur=head;
        int n=0;
        while (cur!=null){
            n++;
            cur=cur.next;
        }
        cur=head;
        for (int i=0;i<n-k;++i){
            cur=cur.next;
        }
        return cur;

    }
}
