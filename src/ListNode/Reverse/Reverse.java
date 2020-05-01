package ListNode.Reverse;

import ListNode.ListNode;

public class Reverse {
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            throw new IllegalArgumentException("null");
        }

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);

        head.next = L1;
        L1.next = L2;

        ListNode newList = reverseList(head);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
// result : 321