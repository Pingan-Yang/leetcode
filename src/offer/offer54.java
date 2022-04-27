package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName offer54
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 20:59
 * @Version:1.0
 */
public class offer54 {
   // List<Integer> list=new ArrayList<>();
    int k,res;
    public int kthLargest(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        this.k=k;
        dfs(root);
       // return list.get(list.size()-k);
        return res;
    }
    private void dfs(TreeNode root){
        if (root==null){
            return;
        }
        //dfs(root.left);
        dfs(root.right);
        if (k==0){
            return;
        }
        if (--k==0){
            res=root.val;
        }
       // list.add(root.val);
       // dfs(root.right);
        dfs(root.left);
    }

    @Test
    public void test(){
        TreeNode root=new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(2);

        root.left=node2;
        root.right=node3;
        node2.right=node4;

        int i = kthLargest(root, 1);
        System.out.println(i);

    }

}
