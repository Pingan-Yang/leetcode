package offer;

/**
 * @ClassName offer27
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/19 20:04
 * @Version:1.0
 */
public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return root;
        }

        //分别记录节点的左右子树
        TreeNode left=root.left;
        TreeNode right=root.right;
        //交换左右子树的节点
        root.left=right;
        root.right=left;
        //分别在 左子树  和右子树上递归这个过程
        mirrorTree(root.left);
        mirrorTree(root.right);
        //返回root
        return root;
    }

}
