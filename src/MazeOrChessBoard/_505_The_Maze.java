package MazeOrChessBoard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _505_The_Maze {        //一次走多步
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static private int m;
    static private int n;
    public static int maze(int[][] matrix, int[] start, int[] end){
        m = matrix.length;
        n = matrix[0].length;
        Queue<Point> queue = new LinkedList<>();
        int[][] dists = new int[m][n];
        for(int[] dist : dists){
            Arrays.fill(dist, -1);
        }
        queue.offer(new Point(start[0], start[1]));
        dists[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for(int[] dir : dirs){
                    int newX = cur.x;
                    int newY = cur.y;
                    int dis = 0;
                    while(isValid(matrix, newX + dir[0], newY + dir[1])){
                        newX += dir[0];
                        newY += dir[1];
                        dis++;
                    }
                    if(dists[newX][newY] == -1 || dists[cur.x][cur.y] + dis < dists[newX][newY]){
                        queue.offer(new Point(newX, newY));
                        dists[newX][newY] = dists[cur.x][cur.y] + dis;
                    }
                }
            }
        }
        return dists[end[0]][end[1]];
    }

    private static boolean isValid(int[][] matrix, int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 3};
        int[] end = new int[]{4, 4};
        System.out.println(maze(maze, start, end));
    }
}
