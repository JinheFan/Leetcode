package Tree.LevelOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderDFS {
    public static void levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return;
        }
        helper(res, root, 0);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
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
        levelOrderDFS(root);
    }
}
