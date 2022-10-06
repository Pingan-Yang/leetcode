package oppo;

import hot100.ListNode;
import org.junit.Test;

import java.util.List;

public class Main2 {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        ListNode listNode1 = sortList(node1);
        ListNode listNode2 = sortList(node2);

        if (listNode1==null){
            return listNode2;
        }else if(listNode2==null){
            return listNode1;
        }else if(listNode1.val<listNode2.val){
            listNode1.next=combineTwoDisorderNodeToOrder(listNode1.next,listNode2);
            return listNode1;
        }else{
            listNode2.next=combineTwoDisorderNodeToOrder(listNode1,listNode2.next);
            return listNode2;
        }
    }
    public ListNode sortList(ListNode head) {
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

    //{3,4,1},{5,6,2}
    @Test
    public void test(){
        ListNode l1=new ListNode(3);
        ListNode l1_node2=new ListNode(4);
        ListNode l1_node3=new ListNode(1);
        l1.next=l1_node2;
        l1_node2.next=l1_node3;


        ListNode l2=new ListNode(5);
        ListNode l2_node2=new ListNode(6);
        ListNode l2_node3=new ListNode(2);
        l2.next=l2_node2;
        l2_node2.next=l2_node3;

        ListNode node = combineTwoDisorderNodeToOrder(l1, l2);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }


//        ListNode node1 = sortList(l1);
//        while(node1!=null){
//            System.out.println(node1.val);
//            node1=node1.next;
//        }
//
//        System.out.println("------------------------");
//
//        ListNode node2 = sortList(l2);
//        while(node2!=null){
//            System.out.println(node2.val);
//            node2=node2.next;
//        }


    }

}
