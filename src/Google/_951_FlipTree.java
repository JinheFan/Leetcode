package Google;

public class _951_FlipTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        boolean leftLeft = flipEquiv(root1.left, root2.left);
        boolean leftRight = flipEquiv(root1.left, root2.right);
        boolean rightLeft = flipEquiv(root1.right, root2.left);
        boolean rightRight = flipEquiv(root1.right, root2.right);

        if((leftLeft && rightRight) || (leftRight && rightLeft)){
            return true;
        }
        return false;
    }
}
