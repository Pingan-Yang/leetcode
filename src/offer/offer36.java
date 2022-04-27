package offer;

import org.junit.Test;

/**
 * @ClassName offer36
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 19:58
 * @Version:1.0
 */
public class offer36 {
    Node2 pre;//前驱节点
    Node2 head;//头节点

    public Node2 treeToDoublyList(Node2 root) {
        //树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继

        // 考虑使用中序遍历访问树的各节点 cur
        // 并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向
        // 中序遍历完成后，最后构建头节点和尾节点的引用指向即可。
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node2 cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    @Test
    public void test() {
        Node2 root = new Node2(4);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(5);
        Node2 node4 = new Node2(1);
        Node2 node5 = new Node2(3);

        root.left=node2;
        root.right=node3;
        node2.left=node4;
        node2.right=node5;

        Node2 head = treeToDoublyList(root);
        int count=0;
        while (count<5){
            count++;
            System.out.println(head.val);
            head=head.left;
        }
    }
}
