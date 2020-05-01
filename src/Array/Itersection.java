package Array;

import java.util.HashSet;

public class Itersection {

    public static void iterection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num1 : nums1){
            set1.add(num1);
        }
        for(int num2 : nums2){
            if(set1.contains(num2)){
                set2.add(num2);
            }
        }
        for(int num : set2){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 3, 4};
        int[] nums2 = new int[] {2, 4, 4, 5};
        iterection(nums1, nums2);
    }
}
