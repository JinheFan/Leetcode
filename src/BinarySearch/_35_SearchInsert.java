package BinarySearch;
/**
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * (start <= end) 适用于找数组中没有的
 * (start + 1 < end) 适用于找数组中两个元素
 * */
public class _35_SearchInsert {
    public static int searchInsert(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
