package test.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BaniryTreePaths {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {

            this.val = val;
        }

    }

    public void TreePath(TreeNode root){
        if(root == null){
            return;
        }
        List<String> res = new ArrayList<>();
        helper(root, res, "");
    }

    private void helper(TreeNode cur, List<String> res, String path){
        if(cur.left == null && cur.right == null){
            path += cur.val;
            res.add(path);
            return;
        }
        if(cur.left != null){
            helper(cur.left, res, path + cur.val + "->");
        }
        if(cur.right != null){
            helper(cur.right, res, path + cur.val + "->");
        }

    }
}
