package Heap.IndexHeap;
/**
 * Input: [3,4,-1,1]
 * Output: 2
 * */
public class _41_FirstMissingPositive {
    public static int firstMissingPositive(int[] nums){
        if(nums == null || nums.length == 0){
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
