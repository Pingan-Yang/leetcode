package offer;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName offer32I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 10:47
 * @Version:1.0
 */
public class offer32I {
    // 二叉树的层序遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node.left=node2;
        node.right=node3;
        node3.left=node4;
        node3.right=node5;
        int[] order = levelOrder(node);
        System.out.println(Arrays.toString(order));
    }
}
