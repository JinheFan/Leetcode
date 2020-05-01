package ListNode.Sum;

import ListNode.ListNode;

public class Sum {
    public static ListNode listSum(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode l1 = p1;
        ListNode l2 = p2;
        int sum = 0;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if(sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);

        p1.next = L1;
        L1.next = L2;


        ListNode p2 = new ListNode(1);
        ListNode pL1 = new ListNode(2);
        ListNode pL2 = new ListNode(3);

        p2.next = pL1;
        pL1.next = pL2;

        ListNode newList = listSum(p1, p2);
        while(newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
// result : 246