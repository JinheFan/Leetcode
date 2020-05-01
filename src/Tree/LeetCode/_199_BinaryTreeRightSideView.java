package Tree.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _199_BinaryTreeRightSideView {
    /**
     * 199. Binary Tree Right Side View
     * given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.

     For example:
     Given the following binary tree,
        1            <---
     /   \
     2     3         <---
     \     \
     5     4       <---
     You should return [1, 3, 4].

     root 1 res : 0 level : 1

     res : 1, 3, 4

     time : O(n);
     time ; O(n);
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }
}
