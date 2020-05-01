package Amazon;

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    /**
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     *
     * time : O(nlogk)
     * space : O(k)
     *
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
