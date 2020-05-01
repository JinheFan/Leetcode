package Tree.PostOrder;

import java.util.ArrayList;
import java.util.List;

public class PostOrderDFS {
    public static void postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        helper(res, root);
        print(res);
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
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
        postOrder(root);
    }
}
