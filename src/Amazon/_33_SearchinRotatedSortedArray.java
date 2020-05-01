package Amazon;

/*
*Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 */

public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){           // 前半段递增
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{          //后半段递增
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
