package hot100;

/**
 * @ClassName leetcode2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/29 10:40
 * @Version:1.0
 */
public class leetcode2 {
    ListNode head=new ListNode();
    ListNode pHead=head;
    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }

        add(l1,l2,carry);
        return pHead.next;

    }
    private ListNode add(ListNode l1, ListNode l2,int carry){
        if(l1==null&&l2==null&&carry==0){
            return null;
        }
        int sum=0;
        if(l1!=null){
            sum+=l1.val;
            l1=l1.next;
        }
        if(l2!=null){
            sum+=l2.val;
            l2=l2.next;
        }
        sum+=carry;
        carry=sum/10;
        sum=sum%10;
        ListNode node=new ListNode(sum);
        head.next=node;
        head=head.next;
        return add(l1,l2,carry);
    }

}
