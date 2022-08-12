package HUAWEI_JIAHI;

import java.util.Scanner;

/**
 * @ClassName HJ48
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/4 15:59
 * @Version:1.0
 */

/**
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 *
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 *
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 *
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 *
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 最后一个参数为2，表示要删掉节点为2的值
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 * 数据范围：链表长度满足 1≤n≤1000  ，节点中的值满足 0≤val≤10000
 *
 * 测试用例保证输入合法
 *
 *
 * 输入描述：
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述：
 * 输出一行
 * 输出删除结点后的序列，每个数后都要加空格
 */
public class HJ48 {
    private ListNode head;
    public HJ48(int val) {
        head=new ListNode(val);
    }
    public void insert(int val, int node) {
        ListNode p = head;
        while (p.val != node) {
            p = p.next;
        }
        ListNode newNode = new ListNode(val, p.next);
        p.next = newNode;
    }
    public void delete(int nodeValue) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null && p.next.val != nodeValue) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = dummy.next;
    }

    public ListNode getHead() {
        return this.head;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int val=sc.nextInt();
            HJ48 solution = new HJ48(val);
            for (int i=1;i<n;++i){
                int pre=sc.nextInt();
                int nodeValue=sc.nextInt();
                solution.insert(pre,nodeValue);
            }
            int deleteValue=sc.nextInt();
            solution.delete(deleteValue);
            ListNode head = solution.getHead();
            while (head!=null){
                System.out.print(head.val+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}
class ListNode{
    int val;
    ListNode next;


    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
