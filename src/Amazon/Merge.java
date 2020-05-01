package Amazon;

import ListNode.ListNode;

public class Merge {
    public static ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        ListNode l1 = p1;
        ListNode l2 = p2;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if(l1 != null) {
            cur.next = l1;
        }

        if(l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode L1 = new ListNode(9);

        head1.next = L1;

        ListNode head2 = new ListNode(2);
        ListNode L2 = new ListNode(4);

        head2.next = L2;

        ListNode newList = mergeTwoLists(head1, head2);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
// result : 1249