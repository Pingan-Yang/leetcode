package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName offer34
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 19:38
 * @Version:1.0
 */
public class offer34 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root==null){
            return res;
        }
        dfs(root,target);
        return res;
    }
    private void dfs(TreeNode root,int target){
        //如果是叶子节点，且此时target==root.val
        if (target==root.val&&root.left==null&&root.right==null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(root.val);

        if (root.left!=null){
            dfs(root.left,target-root.val);
            path.remove(path.size()-1);
        }

        if (root.right!=null){
            dfs(root.right,target-root.val);
            path.remove(path.size()-1);
        }
    }

    @Test
    public void test(){
        TreeNode root=new TreeNode(5);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(8);
        TreeNode node4=new TreeNode(11);
        TreeNode node5=new TreeNode(13);
        TreeNode node6=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(2);
        TreeNode node9=new TreeNode(5);
        TreeNode node10=new TreeNode(1);


        root.left=node2;
        root.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;

        int targetSum=22;
        List<List<Integer>> list = pathSum(root, targetSum);
        System.out.println(list);
    }
}
