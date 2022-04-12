package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode94
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/12 21:52
 * @Version:1.0
 */
public class leetcode94 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        inOrder(root);
        return res;
    }
    private void  inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}
