package test.LeetCode;

import java.util.Arrays;

public class _238_ProductofArrayExceptSelf {
    public static int[] productArray(int[] nums){
        if(nums == null || nums.length < 2){
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = nums[i - 1] * res[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productArray(nums)));
    }
}
