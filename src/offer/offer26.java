package offer;

/**
 * @ClassName offer26
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/19 19:47
 * @Version:1.0
 */
public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null||B==null){
            return false;
        }
        //接下来有以下这几种情况
        //A的根节点 VS B的根节点（A的左右子树节点 VS B的左右子树节点）
        // 1、A的根节点与B的根节点相同，依次比较他们的子节点
        // 2、A的根节点与B的根节点不相同，A的左子树 VS B的根节点
        // 3、A的根节点与B的根节点不行同，A的右子树 VS B的根节点
        return myIsSubStructure(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right, B);
    }
    private boolean myIsSubStructure(TreeNode A, TreeNode B){
        if (A==null&&B!=null){
            return false;
        }
        if (B==null){
            return  true;
        }
        if (A.val!=B.val){
            return false;
        }

        return myIsSubStructure(A.left,B.left)&&myIsSubStructure(A.right,B.right);
    }
}
