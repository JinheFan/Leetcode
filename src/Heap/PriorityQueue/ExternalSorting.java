package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalSorting {
    public static int[] externalSorting(int[][] arrays) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
        for(int i = 0; i < arrays.length; i++) {
            if(arrays[i].length != 0) {
                pq.offer(new ArrayContainer(arrays[i], 0));
            }
        }
        while(!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            list.add(ac.array[ac.index++]);
            if(ac.index < ac.array.length) {
                pq.offer(new ArrayContainer(ac.array, ac.index));
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for(int num : list) {
            res[k++] = num;
        }
        return res;
    }

    private static class ArrayContainer implements Comparable<ArrayContainer>{
        int[] array;
        int index;
        public ArrayContainer(int[] array, int index) {
            super();
            this.array = array;
            this.index = index;
        }
        public ArrayContainer() {
            super();
        }
        @Override
        public int compareTo(ArrayContainer o) {
            return this.array[this.index] - o.array[o.index];
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {5, 6, 7};
        int[] array3 = new int[] {8, 9};
        System.out.println(Arrays.toString(externalSorting(new int[][] {array1, array2, array3})));
    }
}
