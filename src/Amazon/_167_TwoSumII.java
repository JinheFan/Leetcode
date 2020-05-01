package Amazon;

public class _167_TwoSumII {
    /**
     * 167. Two Sum II - Input array is sorted
     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2

     time : O(n)
     space : O(1)

     */

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
