package Tree.Inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIteration {
    public static void inorderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        print(res);
    }

    public static void print(List<Integer> res) {
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);

        root.left = t1;
        root.right = t2;
        inorderIteration(root);
    }
}
