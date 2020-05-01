package Greedy;

public class _55_JumpGame {

    public static boolean jump(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > max){
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
