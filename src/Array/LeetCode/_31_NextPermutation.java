package Array.LeetCode;
/**
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * */
public class _31_NextPermutation {
    static int first = -1;
    static int second = -1;
    public static void nextPermutation(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        first = findFirst(nums);
        if(first == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        second = findSecond(nums);
        swap(nums, first, second);
        reverse(nums, first + 1, nums.length - 1);
        return;
    }

    private static int findFirst(int[] nums){
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                return i;
            }
        }
        return -1;
    }

    private static int findSecond(int[] nums){
        for(int i = nums.length - 1; i > first; i--){
            if(nums[i] > nums[first]){
                return i;
            }
        }
        return -1;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
