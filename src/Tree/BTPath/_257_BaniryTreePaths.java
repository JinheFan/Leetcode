package Tree.BTPath;

import java.util.ArrayList;
import java.util.List;
/**
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 * */
public class _257_BaniryTreePaths {
    public static List<String> path(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root, res, "");
        return res;
    }

    private static void helper(TreeNode root, List<String> res, String path){
        if(root.left == null && root.right == null){
            res.add(path + root.val);
            return;
        }
        if(root.left != null){
            helper(root.left, res, path + root.val + "->");
        }
        if(root.right != null){
            helper(root.right, res, path + root.val + "->");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        TreeNode l4 = new TreeNode(5);
        TreeNode l5 = new TreeNode(6);

        root.left = l1;
        root.right = l2;
        l1.left = l3;
        l1.right = l4;
        l2.right = l5;

        List<String> res = new ArrayList<>();
        res = path(root);
        for(String str : res){
            System.out.println(str);
        }
    }
}
