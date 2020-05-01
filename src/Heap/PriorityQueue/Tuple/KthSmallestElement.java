package Heap.PriorityQueue.Tuple;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple cur = pq.poll();
            if(cur.x == matrix.length - 1) {
                continue;
            }
            pq.offer(new Tuple(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }

        Tuple res = pq.poll();
        return res.val;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;

        System.out.println(kthSmallest(matrix, k));   // 13
    }
}
