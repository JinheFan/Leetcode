package ListNode.Cycle;
import ListNode.ListNode;

public class IsCycle {
    public static boolean isCycle(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(4);

        head.next = L1;
        L1.next = L2;
        L2.next = L3;
        L3.next = head;

        System.out.print(isCycle(head));
    }
}
