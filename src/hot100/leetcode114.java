package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode114
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 20:43
 * @Version:1.0
 */
public class leetcode114 {
    List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        preOrder(root);
        for (int i=0;i<list.size()-1;++i){
            list.get(i).right=list.get(i+1);
            list.get(i).left=null;
        }
        list.get(list.size()-1).left=null;
    }
    private void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

}
