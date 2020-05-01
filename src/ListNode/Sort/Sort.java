package ListNode.Sort;

import ListNode.ListNode;

public class Sort {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;

        while(cur != null && cur.next != null) {
            if(cur.val <= cur.next.val) {
                cur = cur.next;
            }else {
                temp = cur.next;
                cur.next = temp.next;
                pre = dummy;
                while(pre.next.val <=  temp.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(4);
        ListNode L2 = new ListNode(2);
        ListNode L3 = new ListNode(3);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;

        ListNode newList = sortList(head);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
