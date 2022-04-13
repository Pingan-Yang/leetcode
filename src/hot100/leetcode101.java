package hot100;

/**
 * @ClassName leetcode101
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 20:44
 * @Version:1.0
 */
public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
//        1、左子数右子树值相等
//        2、左子数的左子数=右子树的右子树 且 左子数的右子树=右子树的左子数
        if (root==null){
            return false;
        }
        return symmetric(root.left,root.right);
    }
    private boolean symmetric(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return  false;
        }

        return left.val==right.val&&symmetric(left.left, right.right)&&symmetric(left.right,right.left);
    }
}
