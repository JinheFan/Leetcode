package DFS;

import java.util.HashMap;

public class TargetNum {

    public static int targetNum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(map, nums, target);
    }

    private static int helper(HashMap<Integer, Integer> map, int[] nums, int target){
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(map, nums, target - nums[i]);
        }
        map.put(target, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(targetNum(nums, 4));
    }
}
