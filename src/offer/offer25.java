package offer;

import java.util.List;

/**
 * @ClassName offer25
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/25 11:21
 * @Version:1.0
 */
public class offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode newHead=new ListNode();
        ListNode temp=newHead;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                newHead.next=l1;
                newHead=newHead.next;
                l1=l1.next;
            }else{
                newHead.next=l2;
                newHead=newHead.next;
                l2=l2.next;
            }
        }
        if (l1!=null){
            newHead.next=l1;
        }
        if (l2!=null){
            newHead.next=l2;
        }
        return temp.next;
    }
}
