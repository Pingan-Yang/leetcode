package hot100;

import org.junit.Test;

/**
 * @ClassName leetcode98
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 19:33
 * @Version:1.0
 */
public class leetcode98 {
    private long preValue=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return  true;
        }
        boolean validBST = isValidBST(root.left);
        if (!validBST){
            return false;
        }
        if (root.val>preValue){
            preValue=root.val;
        }else{
            return  false;
        }
        boolean validBST1 = isValidBST(root.right);
        if (!validBST1){
            return false;
        }

        return true;
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left=node1;
        node.right=node2;
        boolean validBST = isValidBST(node);
        System.out.println(validBST);
    }
}
