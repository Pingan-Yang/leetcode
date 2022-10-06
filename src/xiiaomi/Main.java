package xiiaomi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    Node pre,head;
    /* Write Code Here */
    public Node  Convert(Node pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        Node lefeHead=Convert(pRootOfTree.left);
        Node leftTail=lefeHead;
        while(leftTail!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        if(lefeHead!=null){
            leftTail.right=pRootOfTree;
            pRootOfTree.left=leftTail;
        }
        Node rightHead=Convert(pRootOfTree.right);

        if (rightHead!=null){
            pRootOfTree.right=rightHead;
            rightHead.left=pRootOfTree;
        }
        return lefeHead!=null?lefeHead:pRootOfTree;

    }
    private void dfs(Node cur){
        if(cur==null){
            return;
        }
        dfs(cur.left);
        if(pre!=null){
            pre.right=cur;
        }else{
            head=cur;
        }
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Node res = null;
        List<Node> list = new ArrayList<>();

        /**
         * 10
         * 6
         * 14
         * 4
         * 8
         * 12
         * 16
         */
        while (in.hasNext()) {
            int item = in.nextInt();
            if (item == -1) {
                list.add(null);
            } else {
                list.add(new Node(item));
            }
            if (item==-100){
                break;
            }
        }
        int len = list.size();
        int i = 0;
        while (i <= (len - 2) / 2) {
            if (2 * i + 1 < len && list.get(i) != null) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 < len && list.get(i) != null) {
                list.get(i).right = list.get(2 * i + 2);
            }
            i++;
        }

        res = new Solution().Convert(list.get(0));
        if (res != null) {
            while (res.right != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.right;
            }
            System.out.print(res.data + " ");
            while (res.left != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.left;
            }
            System.out.print(res.data);
        }
        System.out.println();
    }
}
