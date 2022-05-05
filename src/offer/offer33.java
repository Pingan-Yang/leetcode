package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName offer33
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/4 11:13
 * @Version:1.0
 */


public class offer33 {
    public boolean verifyPostorder(int[] postorder) {

        return verify(postorder,0,postorder.length-1);

    }

    private boolean verify(int[] postorder,int l ,int r){
        if (l>=r){
            return true;
        }
        // 左  右 根
        int root=postorder[r];
        //寻找第一个大于根节点的数
        int m=l;
        while (postorder[m]<root){
            m++;
        }
        // m 为右子树开始的起点
        int p=m;
        while (postorder[p]>root){
            p++;
        }

        if (p!=r){
            return false;
        }

        return verify(postorder,l,m-1)&&verify(postorder,m,r-1);
    }
}
