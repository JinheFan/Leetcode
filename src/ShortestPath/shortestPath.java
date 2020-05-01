package ShortestPath;

import java.util.LinkedList;
        import java.util.Queue;

public class shortestPath {     //一次走一步
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m;
    private static int n;
    public static int shortest(int[][] matrix, int[] start, int[] end){
        m = matrix.length;
        n = matrix[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        int res = 0;
        while(!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if(cur.x == end[0] && cur.y == end[1]){
                    return res - 1;
                }
                for(int[] dir : dirs){
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];
                    if(isValid(matrix, x, y) && !visited[x][y]){
                        queue.offer(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int[][] matrix, int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 1}
        };
        int[] start = new int[]{0, 0};
        int[] end = new int[]{2, 2};
        System.out.println(shortest(matrix, start, end));
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
