package test.LeetCode;

import java.util.Arrays;
import java.util.TreeMap;

public class findRightInterval {
    public void findRight(int[][] intervals){
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }
        int k = 0;
        for(int i = 0; i < intervals.length; i++){
            Integer key = map.ceilingKey(intervals[i][1]);
            res[k++] = key == null ? -1 : map.get(key);
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 4},
                {2, 3},
                {3, 4}
        };
        findRightInterval find = new findRightInterval();
        find.findRight(intervals);
    }
}