package MazeOrChessBoard;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m;
    static int n;
    public static boolean isPath(int[][] maze, int[] start, int[] end){
        m = maze.length;
        n = maze[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.x == end[0] && cur.y == end[1]){
                return true;
            }
            for(int[] dir : dirs){
                int x = cur.x + dir[0];
                int y = cur.y + dir[1];
                if(isValid(maze, x, y) && !visited[x][y]){
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int i, int j){
        return i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 1;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        int[] start = new int[]{0, 0};
        int[] end = new int[]{2, 3};
        System.out.println(isPath(maze, start, end));
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
