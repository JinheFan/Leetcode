package MazeOrChessBoard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class The_Maze {

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] end){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(start[0], start[1]);
        HashSet<Point> visited = new HashSet<>();

        queue.offer(point);
        visited.add(point);

        while(!queue.isEmpty()){
            Point curPoint = queue.poll();

            for(int[] dir : dirs){
                int curX = curPoint.x;
                int curY = curPoint.y;
                while(isValid(maze, curX + dir[0], curY + dir[1])){
                    curX += dir[0];
                    curY += dir[1];
                }
                if(curX == end[0] && curY == end[1]){
                    return true;
                }
                Point newPoint = new Point(curX, curY);
                if(visited.add(newPoint)){
                    queue.offer(newPoint);
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y){
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 ;
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
        The_Maze Maze = new The_Maze();
        System.out.println(Maze.hasPath(maze, start, end));
    }
}
