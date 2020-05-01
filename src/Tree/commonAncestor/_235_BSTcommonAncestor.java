package Tree.commonAncestor;
/**
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * */
public class _235_BSTcommonAncestor {
    public static TreeNode common(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){
            return common(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return common(root.right, p, q);
        }else {
            return root;
        }
    }
}
