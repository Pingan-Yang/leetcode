package hot100;

/**
 * @ClassName leetcode148
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/26 21:01
 * @Version:1.0
 */
public class leetcode148 {
    public ListNode sortList(ListNode head) {
        // 归并排序
//        找到链表的中点，以中点为分界，将链表拆分成两个子链表。
//        寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，
//        当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
//
//        对两个子链表分别排序。
//
//        将两个排序后的子链表合并，得到完整的排序后的链表。
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 寻找照链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode mergeList = merge(list1, list2);
        return mergeList;

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode temp=new ListNode();
        ListNode res=temp;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if (list1!=null){
            temp.next=list1;
        }
        if (list2!=null){
            temp.next=list2;
        }
        return  res.next;
    }
}
