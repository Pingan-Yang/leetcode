package zhongxing;

import offer.TreeNode;

import java.util.*;

public class Main3 {

    public int maxValue(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<List<TreeNode>> level = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                    map.put(cur.left, cur);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    map.put(cur.right, cur);
                }
            }
            level.add(new ArrayList<>(list));
        }

        int index = -1;
        int targetIndex = 0;
        int max = 0;
        for (List<TreeNode> le : level) {
            index++;
            int sum = 0;
            Iterator<TreeNode> iterator = le.iterator();
            while (iterator.hasNext()) {
                TreeNode treeNode = iterator.next();
                sum += treeNode.val;
            }
            if (sum > max) {
                max = sum;
                targetIndex = index;
            }
        }
        List<TreeNode> targetLevel = level.get(targetIndex);
        Iterator<TreeNode> iterator = targetLevel.iterator();
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            max = Math.max(max, max - node.val + map.get(node).val);
        }
        return max;
    }
}
