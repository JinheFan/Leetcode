package Tree.AVL;

public class AVLNode {
    int val;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
