package Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_InsertInterval_Array {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length < 2) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        int length = intervals.length;
        int i = 0;
        while(i < length && intervals[i][1] < newInterval[0]) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int start = 0;
        int end = 0;
        while(i < length && intervals[i][0] < newInterval[1]) {
            start = Math.min(intervals[i][0], newInterval[0]);
            end = Math.max(intervals[i++][1], newInterval[1]);
        }
        res.add(new int[]{start, end});
        while(i < length) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int size = res.size();
        int[][] result = new int[size][2];
        for(int index = 0; index < size; index++) {
            result[index] = res.get(index);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[] {4, 8};
        int[][] res = insert(intervals, newInterval);
        for(int[] list : res) {
            System.out.println(Arrays.toString(list));
        }
    }
}
