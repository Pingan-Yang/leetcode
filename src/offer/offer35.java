package offer;

import java.util.HashMap;

/**
 * @ClassName offer35
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/14 22:38
 * @Version:1.0
 */
public class offer35 {
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }

        return map.get(head);

    }
}

