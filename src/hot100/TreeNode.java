package hot100;

/**
 * @ClassName TreeNode
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/12 21:53
 * @Version:1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
