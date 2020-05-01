package Tree.BTPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * */
class _113_PathSum {
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.val == sum){
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(8);
        TreeNode l3 = new TreeNode(11);
        TreeNode l4 = new TreeNode(13);
        TreeNode l5 = new TreeNode(4);
        TreeNode l6 = new TreeNode(7);
        TreeNode l7 = new TreeNode(2);
        TreeNode l8 = new TreeNode(5);
        TreeNode l9 = new TreeNode(1);

        root.left = l1;
        root.right = l2;
        l1.left = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = l6;
        l3.right = l7;
        l5.left = l8;
        l5.right = l9;

        List<List<Integer>> res = new ArrayList<>();
        res = pathSum(root, 22);
        for (List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
