package Greedy;

import java.util.Arrays;

/**
 *Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 *
 * end = Math.min(end, points[i][1]);
 * |_______|        |________|
 *      |_______________|           // 需要刺两次
 * */
public class _452_BurstBallons {
    public static int burstBallons(int[][] points){
        if(points == null || points.length == 0){
            return 0;
        }
        int res = 1;
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > end){
                res++;
                end = points[i][1];
            }else{
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(burstBallons(points));
    }
}
