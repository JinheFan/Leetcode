package Tree.BTPath;

public class DoublePre {
    public static boolean doublePre(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return doublePre(root.left, sum - root.val) || doublePre(root, sum - root.val);
    }
}
