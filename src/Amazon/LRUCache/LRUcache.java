package Amazon.LRUCache;

import java.util.HashMap;

public class LRUcache {
    public HashMap<Integer, Node> map;
    public int capacity;
    public Node head;
    public Node tail;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public void put(int key, int val){
        Node newNode = new Node(key, val);
        Node node = map.get(key);
        if(node != null){
            if(node != tail){
                if(node == head){
                    head = head.next;
                }else{
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        }else{
            if(capacity == 0){
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if(head == null && tail == null){
                head = newNode;
            }else{
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        if(node != tail){
            if(node == head){
                head = head.next;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }
}
