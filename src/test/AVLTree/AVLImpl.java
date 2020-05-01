package test.AVLTree;

import java.util.ArrayList;
import java.util.List;

public class AVLImpl {
    int size;
    AVLTreeNode root;

    public AVLImpl() {
        this.root = null;
        this.size = 0;
    }

    public void add(int val){
        add(root, val);
    }

    private AVLTreeNode add(AVLTreeNode cur, int val){
        if(cur.val == val){
            System.out.println("Node exists");
        }
        if(cur.val < val){
            cur.right = add(cur.right, val);
        }else if(cur.val > val){
            cur.left = add(cur.left, val);
        }
        cur.height = Math.max(height(cur.left), height(cur.right)) + 1;
        return cur;
    }

    private int height(AVLTreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        return Math.max(left, right);
    }

    public boolean isBST(AVLTreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        for(int i = 1; i < res.size(); i++){
            if(res.get(i) <= res.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    private void helper(List<Integer> res, AVLTreeNode root){
        if(root == null){
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public boolean isBalanced(AVLTreeNode root){
        if(root == null){
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(AVLTreeNode cur){
        if(cur == null){
            return 0;
        }
        int left = helper(cur.left) + 1;
        int right = helper(cur.right) + 1;
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right);
    }

}
