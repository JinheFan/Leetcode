package test.AVLTree;

public class AVLTreeNode {
    int val;
    int height;
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(int val) {
        this.val = val;
        this.height = 1;
        left = null;
        right = null;
    }
}
