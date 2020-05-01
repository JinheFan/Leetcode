package BackTracking;
/**
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_Permutation {
    public static List<List<Integer>> permutaion(int[] nums){   // 有问题
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            helper(res, list,nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res = permutaion(nums);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
