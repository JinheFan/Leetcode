package DFS.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * time : O(2 ^ n)
 * space : O(n)
 * */
public class _40_CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
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
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums, target - nums[i], i + 1);  // 一个元素只能使用一次
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(nums, target);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
