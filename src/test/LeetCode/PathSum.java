package test.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void findPath(TreeNode root, int target){
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), root, target);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode cur, int target){
        if(cur == null){
            return;
        }
        list.add(cur.val);
        if(cur.val == target){
            res.add(new ArrayList<>(list));
        }
        helper(res, list, cur.left, target - cur.val);
        helper(res, list, cur.right, target - cur.val);
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

        PathSum pathSum = new PathSum();
        pathSum.findPath(root, 22);
    }
}
