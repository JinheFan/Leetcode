package Google;

public class _124_BinaryTreeMaximumPathSum {
    /**
     * 124. Binary Tree Maximum Path Sum
     * Given a binary tree, find the maximum path sum.

     For this problem, a path is defined as any sequence of nodes from some starting node to any node
     in the tree along the parent-child connections. The path must contain at least one node and does not
     need to go through the root.

     For example:
     Given the below binary tree,

     1
     / \
     2   3
     Return 6.

     Input: [-10,9,20,null,null,15,7]

     -10
     / \
     9  20
     /  \
     15   7

     Output: 42


     time : O(n)
     space : O(n)

     */

    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
