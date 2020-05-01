package test.LeetCode;

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    public static int KthLargest(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(KthLargest(nums, k));
    }
}
