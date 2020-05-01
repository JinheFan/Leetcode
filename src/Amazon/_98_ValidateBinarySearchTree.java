package Amazon;

import java.util.ArrayList;
import java.util.List;

public class _98_ValidateBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> list, TreeNode root){
        if(root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

}
