package MazeOrChessBoard;

import java.util.LinkedList;
import java.util.Queue;

class _490_The_Maze {
        public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(start[0], start[1]));
            visited[start[0]][start[1]] = true;
            while(!queue.isEmpty()){
                Point cur = queue.poll();
                if(cur.x == destination[0] && cur.y == destination[1]) return true;
                for(int[] direction : directions){
                    int newX = cur.x;
                    int newY = cur.y;
                    while(isValid(maze, newX + direction[0], newY + direction[1])){
                        newX += direction[0];
                        newY += direction[1];
                    }
                    if(!visited[newX][newY]){
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            return false;
        }

        private static boolean isValid(int[][] maze, int x, int y){
            return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
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
        System.out.println(hasPath(maze, start, end));
    }
}


