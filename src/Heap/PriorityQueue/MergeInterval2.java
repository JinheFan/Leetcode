package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval2 {
    public void merge(int[][] intervals){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                end = Math.max(end, intervals[i][1]);
            }else {
                lists.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        lists.add(Arrays.asList(start, end));
        for(int i = 0; i < lists.size(); i++){
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10}
        };
        MergeInterval2 mergeInterval = new MergeInterval2();
        mergeInterval.merge(intervals);
    }
}
