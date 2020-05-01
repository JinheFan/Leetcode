package BinarySearch;
/**
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * */
public class _34_SearchRange {
    public static int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int first = -1;
        int second = -1;
        first = findFirst(nums, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        second = findSecond(nums, target);
        res[0] = first;
        res[1] = second;
        return res;
    }

    private static int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;

    }

    private static int findSecond(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            return end;
        }
        if(nums[start] == target){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        for(int num : res){
            System.out.println(num);
        }
    }
}
