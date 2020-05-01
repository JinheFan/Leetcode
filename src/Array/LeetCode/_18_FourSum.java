package Array.LeetCode;
/**
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_FourSum {
    public static void fourSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i - 1] ==  nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i && nums[j - 1] ==  nums[j]){
                    continue;
                }
                int start = j + 1, end = nums.length - 1;
                while(start < end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == 0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while(start < end && nums[start] == nums[start + 1]){
                            start++;
                        }
                        while(start < end && nums[end] == nums[end - 1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(sum < 0){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        fourSum(nums);
    }
}
