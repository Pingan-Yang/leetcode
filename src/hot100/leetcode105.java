package hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName leetcode105
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/18 20:04
 * @Version:1.0
 */
public class leetcode105 {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 前序： 根 左 右
        // 中序： 左 根 右
        // 使用Arrays.copyOfRange()不断地复制数组 消耗性能
        if (preorder==null||inorder==null||preorder.length==0||inorder.length==0){
            return null;
        }

        //建立根节点
        TreeNode root = new TreeNode(preorder[0]);
        //找到左右子树 分别递归建立左右子树节点
        int n=inorder.length;
        for(int i=0;i<n;++i){
            if (root.val==inorder[i]){
                root.left=buildTree1(Arrays.copyOfRange(preorder, 1,i+1),
                        Arrays.copyOfRange(inorder, 0,i));
                root.right=buildTree1(Arrays.copyOfRange(preorder,i+1,n),
                        Arrays.copyOfRange(inorder, i+1, n));
            }
        }
        return root;
    }

    // 使用哈希表的方式记录inorder中各个节点的索引位置  加快运算速度
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0,n - 1,  0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
