package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName offer32II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 11:06
 * @Version:1.0
 */
public class offer32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Deque<TreeNode>queue=new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;++i){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
