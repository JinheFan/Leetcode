package DFS.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * time : O(2 ^ n)
 * space : O(n)
 * */
public class _39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        helper(res, new ArrayList<>(), nums, target, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, target - nums[i], i);  // 一个元素可是使用多次
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(nums, target);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
