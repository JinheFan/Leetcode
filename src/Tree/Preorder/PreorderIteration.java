package Tree.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIteration {
    public static void preorderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

        print(res);
    }

    public static void print(List<Integer> res) {
        for(int num : res) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);

        root.left = t1;
        root.right = t2;

        preorderIteration(root);
    }
}
