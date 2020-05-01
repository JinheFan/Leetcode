package Tree.Preorder;

import java.util.ArrayList;
import java.util.List;

public class PreorderDFS {
    public void preorderDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        helper(root, res);
        print(res);
    }

    public void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    public void print(List<Integer> res) {
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;

        PreorderDFS preorder = new PreorderDFS();
        preorder.preorderDFS(root);
    }
}
