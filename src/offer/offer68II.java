package offer;

/**
 * @ClassName offer68II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 20:05
 * @Version:1.0
 */
public class offer68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode leftAncestor=lowestCommonAncestor(root.left, p,q);
        TreeNode rightAncestor=lowestCommonAncestor(root.right, p,q);
        //leftAncestor rightAncestor都不为空 说明pq在root的两侧
        if (leftAncestor!=null&&rightAncestor!=null){
            return root;
        }
        return leftAncestor!=null?leftAncestor:rightAncestor;
    }
}
