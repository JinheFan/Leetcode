package Tree.Inorder;

import java.util.ArrayList;
import java.util.List;

public class InorderDFS {
    public void inorderDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        helper(root, res);
        print(res);
    }

    public void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public void print(List<Integer> res) {
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


        InorderDFS inorder = new InorderDFS();
        inorder.inorderDFS(root);
    }
}
