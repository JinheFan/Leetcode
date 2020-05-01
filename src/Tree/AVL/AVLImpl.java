package Tree.AVL;

import java.util.ArrayList;
import java.util.List;

public class AVLImpl {
    int size;

    AVLNode root;

    public AVLImpl() {
        this.size = 0;
        this.root = null;
    }

    public void add(int val) {
        root = add(root, val);
    }

    public AVLNode add(AVLNode node, int val) {
        if(node == null) {
            return new AVLNode(val);
        }
        if(node.val == val) {
            throw new IllegalArgumentException("Node exists");
        }
        if(node.val < val) {
            node.right = add(node.right, val);
        }else {
            node.left =  add(node.left, val);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;

    }

    private boolean isBST(AVLNode root) {
        if(root == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        isBST(root, res);
        for(int i = 1; i < res.size(); i++) {
            if(res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void isBST(AVLNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        isBST(root.left, res);
        res.add(root.val);
        isBST(root.right, res);
    }

    private int height(AVLNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return Math.max(left, right);
    }

    private boolean isBalanced(AVLNode root) {
        if(root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(AVLNode node) {
        if(node == null) {
            return 0;
        }
        int left = helper(node.left) + 1;
        int right = helper(node.right) + 1;
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
