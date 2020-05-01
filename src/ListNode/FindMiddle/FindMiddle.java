package ListNode.FindMiddle;
import ListNode.ListNode;

public class FindMiddle {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);

        head.next = L1;
        L1.next = L2;

        System.out.print(findMiddle(head).val);  // 2
    }
}
