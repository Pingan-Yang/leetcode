package hot100;




/**
 * @ClassName leetcode21
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/5 20:25
 * @Version:1.0
 */
public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }

        ListNode p1=l1;
        ListNode p2=l2;
        ListNode pHead=new ListNode();
        ListNode res=pHead;
        while (p1!=null&&p2!=null){
            if (p1.val<p2.val){
                pHead.next=p1;
                pHead=pHead.next;
                p1=p1.next;

            }else{
                pHead.next=p2;
                pHead=pHead.next;
                p2=p2.next;
            }
        }
        if (p1!=null){
            pHead.next=p1;
        }
        if (p2!=null){
            pHead.next=p2;
        }


        return res.next;
    }

}
