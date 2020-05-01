package Amazon;

import java.util.Arrays;

public class MeetingRooms {
    public static int meetingrooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int firstEnd = 0;
        for (int i = 0; i < intervals.length; i++) {
            if(start[i] < end[firstEnd]) {
                res++;
            }else {
                firstEnd++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 2},
                {3, 6},
                {5, 8}
        };
        System.out.println(meetingrooms(intervals));    // 2
    }
}
