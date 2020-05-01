package Heap.PriorityQueue;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.PriorityQueue;

public class KsmallestPairs {
    public static int[][] kSmallest(int[] nums1, int[] nums2, int k){
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[][] {};
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});

        }
        while(!pq.isEmpty() && k-- > 0) {
            int[] cur = pq.poll();
            res.add(new int[] {cur[0], cur[1]});
            if(cur[2] == nums2.length) continue;
            pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 4};
        int[] nums2 = new int[] {3, 4, 5};
        int[][] res = kSmallest(nums1, nums2, 4);
        for(int[] list : res) {
            System.out.println(Arrays.toString(list));
        }
    }
}
// result :
// [1, 3]
//[2, 3]
//[1, 4]
//[2, 4]
