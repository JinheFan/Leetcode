package DFS.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {
    /**
     Input: 3
     Output:
     [
     [1,null,3,2],
     [3,2,null,1],
     [3,1,null,null,2],
     [2,1,3],
     [1,null,2,null,3]
     ]
     time : O(n^2);
     space : O(n);
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<>();
        return genTreeList(1, n);
    }

    public List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = genTreeList(start, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
