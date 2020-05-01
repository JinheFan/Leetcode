package Tree.PostOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class PostOrderIteration {
    public static void PostOrderIteration(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if(cur.left != null) {
                stack.add(cur.left);
            }
            if(cur.right != null) {
                stack.add(cur.right);
            }
        }
        System.out.print(Arrays.toString(res.toArray()));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);

        root.left = l1;
        root.right = r1;

        PostOrderIteration(root);
    }
}
