package hot100;

/**
 * @ClassName ListNode
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/29 10:30
 * @Version:1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
