package Amazon;

import Array.Interval.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * */
public class _56_Merge {
    public static List<Interval> merge(List<Interval> intervals){
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() < 2){
            return intervals;
        }
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= end){
                end = Math.max(end, intervals.get(i).end);
            }else{
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        List<Interval> res = merge(intervals);
        for(Interval interval : res){
            System.out.println(interval.start + " " + interval.end);
        }
    }

static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
