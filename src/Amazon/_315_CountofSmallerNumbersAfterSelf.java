package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * 315. Count of Smaller Numbers After Self
     * You are given an integer array nums and you have to return a new counts array.
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

     Example:

     Given nums = [5, 2, 6, 1]

     To the right of 5 there are 2 smaller elements (2 and 1).
     To the right of 2 there is only 1 smaller element (1).
     To the right of 6 there is 1 smaller element (1).
     To the right of 1 there is 0 smaller element.
     Return the array [2, 1, 1, 0].


     time : O(n^2)
     space : O(n)
     */
    class Item {
        int val;
        int index;
        public Item(int v, int i) {
            val = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        int[] count = new int[n];
        mergeSort(items, 0, n - 1, count);
        List<Integer> res = new ArrayList<>();
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int hi, int[] count) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid + 1, hi, count);
        merge(items, lo, mid, mid + 1, hi, count);
    }

    private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
        int m = hiEnd - lo + 1;
        Item[] sorted = new Item[m];
        int rightCounter = 0;
        int loPtr = lo, hiPtr = hi;
        int index = 0;
        while (loPtr <= loEnd && hiPtr <= hiEnd) {
            if (items[loPtr].val > items[hiPtr].val) {
                rightCounter++;
                sorted[index++] = items[hiPtr++];
            } else {
                count[items[loPtr].index] += rightCounter;
                sorted[index++] = items[loPtr++];
            }
        }

        while (loPtr <= loEnd) {
            count[items[loPtr].index] += rightCounter;
            sorted[index++] = items[loPtr++];
        }

        while (hiPtr <= hiEnd) {
            sorted[index++] = items[hiPtr++];
        }

        System.arraycopy(sorted, 0, items, lo, m);
    }

    public static void main(String[] args) {
        _315_CountofSmallerNumbersAfterSelf object = new _315_CountofSmallerNumbersAfterSelf();
        int[] nums = new int[]{5, 2, 6, 1};
        List<Integer> res = object.countSmaller(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}


