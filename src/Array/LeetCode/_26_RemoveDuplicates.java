package Array.LeetCode;
/**
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * */
public class _26_RemoveDuplicates {
    public static void remove(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                nums[count++] = nums[i];
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        remove(nums);
    }
}
