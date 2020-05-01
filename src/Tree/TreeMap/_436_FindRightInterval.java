package Tree.TreeMap;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * */
public class _436_FindRightInterval {
    public static int[] findRightInterval(int[][] intervals){
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < intervals.length; i++){
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1 : map.get(key);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 4},
                {2, 3},
                {3, 4}
        };
        int[] res = findRightInterval(intervals);
        System.out.println(Arrays.toString(res));
    }
}
