package Recursion;

public class FindValueInBST {

    public TreeNode findValue(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        if(root.value == target) {
            return root;
        }
        if(root.value < target) {
            findValue(root.left, target);
        } else {
            findValue(root.right, target);
        }
        return null;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
