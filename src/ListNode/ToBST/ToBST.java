package ListNode.ToBST;

import ListNode.ListNode;

import java.util.*;

public class ToBST {
    public static TreeNode listToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        return helper(head, null);
    }

    private static TreeNode helper(ListNode head, ListNode tail) {
        if(head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(3);

        head.next = L1;
        L1.next = L2;

        TreeNode root = listToBST(head);

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.print(Arrays.toString(res.toArray()));
    }
}
// result : [2, 1, 3]