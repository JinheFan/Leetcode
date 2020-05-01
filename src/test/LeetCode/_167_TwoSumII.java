package test.LeetCode;

import java.util.Arrays;

public class _167_TwoSumII {
    public static int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
