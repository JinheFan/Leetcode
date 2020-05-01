package Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_Merge_Array {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval : intervals) {
            if(interval[0] <= end) {
                end = Math.max(end, interval[1]);
            }else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        int size = res.size();
        int[][] result = new int[size][2];
        for(int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
