package ListNode.Swap;

import ListNode.ListNode;

public class Swap {
    public static ListNode swap(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;

        while(l2 != null && l2.next != null) {
            ListNode newStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = newStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(4);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;

        ListNode newList = swap(head);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
// result : 2143