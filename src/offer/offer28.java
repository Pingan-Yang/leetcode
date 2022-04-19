package offer;

/**
 * @ClassName offer28
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/19 20:23
 * @Version:1.0
 */
public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode L, TreeNode R){
        //base case
        if (L==null&&R==null){
            return true;
        }
        if (L==null||R==null){
            return false;
        }

        if (L.val!=R.val){
            return false;
        }

        return isMirror(L.left,R.right)&&isMirror(L.right, R.left);
    }
}
