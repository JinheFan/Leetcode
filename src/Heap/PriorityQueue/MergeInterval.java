package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length == 0) {
            return new int[][] {};
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval : intervals) {
            if(interval[0] <= end) {
                end = Math.max(end, interval[1]);
            }else {
                res.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[][] {});
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10}
        };
        int[][] res = merge(intervals);
        for(int[] list : res) {
            System.out.println(Arrays.toString(list));
        }
    }
}
// result :
// [1, 6]
//[8, 10]
