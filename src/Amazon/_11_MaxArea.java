package Amazon;
/**
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * */
public class _11_MaxArea {
    public static int maxArea(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while(left < right){
            res = Math.max(res, (right - left) * Math.min(nums[left], nums[right]));   // 不是 right - left + 1, 因为数的是间隙， 不是个数
            if(nums[left] < nums[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
