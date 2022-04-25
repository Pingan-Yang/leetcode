package hot100;


import java.util.HashMap;

/**
 * @ClassName leetcode146
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/20 21:25
 * @Version:1.0
 */
public class leetcode146 {

    public static void main(String[] args) {

    }
}
class LRUCache {
    int capacity;
    //利用hash表和双端队列来做
    // 自己实现双端队列
    HashMap<Integer,Node>map;
    DoubleLinkList cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        cache=new DoubleLinkList();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            int value=map.get(key).value;
            put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            // 如果原来缓存中有值，则更新
            cache.delete(map.get(key));
            map.put(key,node);
            cache.addFirst(node);
        }else{
            // 原来缓存中没有 则插入
            if (map.size()==capacity){
                //达到缓存上限，则删除末尾节点
                int keyDelete = cache.deleteTail();
                map.remove(keyDelete);
            }
            map.put(key,node);
            cache.addFirst(node);
        }
    }
}
class Node{
    int key;
    int value;
    Node pre;
    Node next;
   public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class DoubleLinkList{
    Node head;// 最近使用过的节点
    Node tail;// 最久没被使用过的节点

    public DoubleLinkList() {
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    //从头部插入
    public void addFirst(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    //删除某个节点
    public int delete(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        return node.key;
    }
    //从尾部删除
    public int deleteTail(){
        // 双向链表中没有数据
        if (head.next==tail){
            return -1;
        }

        return delete(tail.pre);
    }
}
