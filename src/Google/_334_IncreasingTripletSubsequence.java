package Google;

public class _334_IncreasingTripletSubsequence {
    /**
     * 334. Increasing Triplet Subsequence
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

     Examples:
     Given [1, 2, 3, 4, 5],
     return true.

     Given [5, 4, 3, 2, 1],
     return false.

     time : O(n)
     space : O(1)

     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, sedMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < sedMin) sedMin = num;
            else if (num > sedMin) return true;
        }
        return false;
    }
}
