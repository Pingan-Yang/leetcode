package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName offer07
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/4 9:43
 * @Version:1.0
 */
public class offer07 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前：根  左  右
        //中：左  根  右

        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        //1.记录中序遍历的索引
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }

        int n = preorder.length;
        return myBuild(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    private TreeNode myBuild(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {

        if (preleft > preright) {
            return null;
        }
        //1.确立根节点索引

        int rootIndex = preleft;

        //2.找到根节点索引在中序中的位置索引
        int inorderRootIndex = map.get(preorder[rootIndex]);
        //3.建立根节点
        TreeNode root=new TreeNode(preorder[rootIndex]);

        //4.计算左子树的长度

        int leftSize=inorderRootIndex-inleft;

        //5.递归建立左右子树
        root.left = myBuild(preorder, inorder, preleft + 1, preleft+leftSize, inleft, inorderRootIndex - 1);
        root.right = myBuild(preorder, inorder, preleft+leftSize + 1, preright, inorderRootIndex + 1, inright);

        return root;


    }
}
