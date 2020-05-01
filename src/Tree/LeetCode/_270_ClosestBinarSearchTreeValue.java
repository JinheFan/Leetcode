package Tree.LeetCode;

public class _270_ClosestBinarSearchTreeValue {
    public int closestValue2(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int val) {
        if (root == null) return val;
        if (Math.abs(root.val - target) < Math.abs(val - target)) {
            val = root.val;
        }
        if (root.val < target) {
            val = helper(root.right, target, val);
        } else if (root.val > target) {
            val = helper(root.left, target, val);
        }
        return val;
    }
}
