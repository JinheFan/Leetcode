package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * */
public class _15_ThreeSum {

    public static void threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == nums[start + 1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end - 1]){
                        end--;
                    }
                    start++;
                    end--;
                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
