package Amazon;

import java.util.HashMap;

public class _138_CopyListwithRandomPointer {
    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer which could
     * point to any node in the list or null.

     Return a deep copy of the list

     time : O(n);
     space : O(n);
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {           // copy points
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {           // connect lines
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
}

class RandomListNode{
        int label;
        RandomListNode next;
        RandomListNode random;
        public RandomListNode(int val){
            this.label = val;
            this.next = null;
            this.random = null;
        }
    }
}
