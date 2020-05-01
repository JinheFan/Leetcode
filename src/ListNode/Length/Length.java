package ListNode.Length;

import ListNode.ListNode;

public class Length {
    public static int length(ListNode head) {
        if(head == null) {
            return 0;
        }

        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(4);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;

        System.out.print(length(head));
    }
}
