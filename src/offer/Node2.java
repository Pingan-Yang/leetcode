package offer;

/**
 * @ClassName Node2
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/27 20:01
 * @Version:1.0
 */
public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, Node2 left, Node2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
