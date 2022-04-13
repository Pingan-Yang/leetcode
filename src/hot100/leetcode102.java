package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName leetcode102
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/13 20:54
 * @Version:1.0
 */
public class leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<Integer> level=new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (node.left!=null){
                    queue.addLast(node.left);
                }
                if (node.right!=null){
                    queue.addLast(node.right);
                }
            }
            res.add(new ArrayList<Integer>(level));
            level.clear();
        }
        return res;

    }

}
