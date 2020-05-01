package ListNode.Delete;
import ListNode.ListNode;

public class Delete {
    public static ListNode delete1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int sameVal = cur.next.val;
                while(cur.next != null && cur.next.val == sameVal) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(3);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(4);
        ListNode L4 = new ListNode(4);
        ListNode L5 = new ListNode(5);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;

        ListNode newList = delete1(head);
        while(newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
// result :  1  5
