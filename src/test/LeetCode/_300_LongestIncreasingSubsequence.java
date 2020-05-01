package test.LeetCode;

public class _300_LongestIncreasingSubsequence {
    public int longestSubsequence(int[] nums){
        if(nums == null || nums.length < 2){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
