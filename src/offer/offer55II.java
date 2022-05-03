package offer;

/**
 * @ClassName offer55II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 10:39
 * @Version:1.0
 */
public class offer55II {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else {
          return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    private int depth(TreeNode root){
       if (root==null){
           return 0;
       }
       int leftdepth=depth(root.left);
       int rightdepth=depth(root.right);

       return Math.max(leftdepth,rightdepth)+1;
    }
}
