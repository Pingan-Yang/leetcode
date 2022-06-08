package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName offer37
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 21:51
 * @Version:1.0
 */
public class offer37 {
    //二叉树的序列化与反序列化
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(TreeNode root,String str){
        if (root==null){
            str+="null,";
        }else{
            str+=String.valueOf(root.val)+",";
            str+=rserialize(root.left,str);
            str+=rserialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }
}
