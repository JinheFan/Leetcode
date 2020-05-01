package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillBFS {

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m;
    static int n;
    public static int floodFill(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new Point(i, j));
                    grid[i][j] = 0;
                    res++;
                    while(!queue.isEmpty()){
                        Point cur = queue.poll();
                        for(int[] dir : dirs){
                            int x = cur.x + dir[0];
                            int y = cur.y + dir[1];
                            if(isValid(grid, x, y)){
                                queue.offer(new Point(x, y));
                                grid[x][y] = 0;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 1}
        };
        System.out.println(floodFill(grid));
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
