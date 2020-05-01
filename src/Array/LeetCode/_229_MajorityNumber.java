package Array.LeetCode;

import java.util.*;
/**
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * */
public class _229_MajorityNumber {
    public static List<Integer> majority(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length / 3){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,2,2,2};
        List<Integer> res = majority(nums);
        for(Integer num : res){
            System.out.println(num);
        }
    }
}
