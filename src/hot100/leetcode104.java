package hot100;

/**
 * @ClassName leetcode104
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 21:02
 * @Version:1.0
 */
public class leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        // 左子树的深度
        int leftDepth=maxDepth(root.left);
        // 右子树的深度
        int rightDepth=maxDepth(root.right);

        // 找到左右子树的最大值+1
        return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
    }
}
