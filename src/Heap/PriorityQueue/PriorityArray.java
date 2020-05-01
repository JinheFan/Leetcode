package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityArray {
    public static void priority() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
    }


    public static void priority1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num : nums) {
            pq.offer(num);
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.poll());
        }
    }

    public static void priority2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for(int num : nums) {
            pq.offer(num);
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        priority2 (nums);
    }

}
