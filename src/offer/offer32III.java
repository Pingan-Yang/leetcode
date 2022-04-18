package offer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @ClassName offer32III
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 11:13
 * @Version:1.0
 */
public class offer32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>>res=new ArrayList<>();
        LinkedList<Integer> list=new LinkedList<>();
        int level=1;
        Deque<TreeNode>queue=new ArrayDeque<>();
        queue.addLast(root);
        //奇数层从尾部添加，偶数层从头部添加
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;++i){
                TreeNode node = queue.removeFirst();
                if (level%2==0){
                    list.addFirst(node.val);
                }else{
                    list.addLast(node.val);
                }
                if (node.left!=null){
                    queue.addLast(node.left);
                }
                if (node.right!=null){
                    queue.addLast(node.right);
                }
            }
            level++;
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
