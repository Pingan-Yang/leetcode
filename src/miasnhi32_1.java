import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName miasnhi32_1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/2/5 16:27
 * @Version:1.0
 */
public class miasnhi32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        ArrayList<Integer> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            res.add(node.val);
            if (node.left!=null){
                queue.add(root.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        int[] resdata=new int[res.size()];
        for (int i=0;i<res.size();++i){
            resdata[i]=res.get(i);
        }
        return resdata;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node4;

        int[] levelOrder = levelOrder(node1);
        System.out.println(Arrays.toString(levelOrder));

    }
}
