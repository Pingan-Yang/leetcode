package offer;

/**
 * @ClassName offer55I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 10:33
 * @Version:1.0
 */
public class offer55I {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int maxleft=maxDepth(root.left);
        int maxright=maxDepth(root.right);

        return Math.max(maxleft,maxright)+1;

    }
}
