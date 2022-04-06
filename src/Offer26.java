/**
 * @ClassName Offer26
 * @Description: TODO
 * @Author 15368
 * @Date 2022/1/21 15:22
 * @Version:1.0
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //A B只要右一个为空 就返回false
        if (A==null||B==null){
            return false;
        }
        //接下来有以下这几种情况
        //A的根节点 VS B的根节点（A的左右子树节点 VS B的左右子树节点）
        // 1、A的根节点与B的根节点相同，依次比较他们的子节点
        // 2、A的根节点与B的根节点不相同，A的左子树 VS B的根节点
        // 3、A的根节点与B的根节点不行同，A的右子树 VS B的根节点

        return isSub(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    private boolean isSub(TreeNode A ,TreeNode B){
        //A和B不匹配的情况很多，需要一开始找到完全匹配的情况

        //①：B已经遍历完，直到为null，说明B与A的子结构相匹配
        if (B==null){
            return true;
        }

        //②：A中的节点为空，但B中节点不为空，说明不匹配
        if (A==null){
            return false;
        }

        //③：A、 B都不为空，但值都不相同，说明不匹配
        if(A.val!=B.val){
            return false;
        }
        //此时，说明这个点是匹配的，继续递归判断左子树、右子树
        return isSub(A.left,B.left)&&isSub(A.right,B.right);

    }
}
