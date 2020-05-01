package Array.LeetCode;

import java.util.Arrays;
/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Input: [3,6,9,1]
 * Output: 3
 * */
public class _164_maximumGap {
    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            res = Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,9,1};
        System.out.println(maximumGap(nums));
    }
}
