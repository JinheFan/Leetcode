package Google;

import java.util.Arrays;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * 315. Count of Smaller Numbers After Self
     * You are given an integer array nums and you have to return a new counts array.
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

     Example:

     Given nums = [5, 2, 6, 1]

     To the right of 5 there are 2 smaller elements (2 and 1).
     To the right of 2 there is only 1 smaller element (1).
     To the right of 6 there is 1 smaller element (1).
     To the right of 1 there is 0 smaller element.
     Return the array [2, 1, 1, 0].


     time : O(n^2)
     space : O(n)
     */
    class TreeNode{
        int smallCount;
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int count, int val){
            this.smallCount = count;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        Integer[] res = new Integer[nums.length];
        if(nums == null || nums.length == 0) return Arrays.asList(res);
        for(int i=nums.length-1; i>=0; i--){
            root = insert(root, nums[i], res, i, 0);
        }
        return Arrays.asList(res);
    }

    public TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int preSum){
        if(root == null){
            root = new TreeNode(0, val);
            ans[index] = preSum;
        }
        else if(root.val>val){
            root.smallCount++;
            root.left = insert(root.left, val, ans, index, preSum);
        }
        else{
            root.right = insert(root.right, val, ans, index, root.smallCount + preSum + (root.val<val?1:0));//only adding 1 on preSum if root.val is only smaller than val
        }
        return root;
    }
}


