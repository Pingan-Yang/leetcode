package offer;

/**
 * @ClassName offer68I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 19:59
 * @Version:1.0
 */
public class offer68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //防止空指针异常
        if (root==null){
            return null;
        }
        if (root.val<p.val&&root.val<q.val){
           return lowestCommonAncestor(root.right, p,q);
        }else if (root.val>p.val&&root.val>q.val){
           return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
