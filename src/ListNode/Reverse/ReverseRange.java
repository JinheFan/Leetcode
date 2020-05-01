package ListNode.Reverse;

import ListNode.ListNode;

public class ReverseRange {
    public static ListNode reverseRange(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        for(int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        for(int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(4);
        ListNode L4 = new ListNode(5);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;

        int m = 2, n = 4;

        ListNode newList = reverseRange(head, m, n);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
// 14325