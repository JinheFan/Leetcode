package Amazon;

/*
* time : O(k * m * n)
* space : O(k)
* */
public class FloodFillDFS {
    public static int numIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    floodfill(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void floodfill(int[][] grid, int m, int n, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;
        floodfill(grid, m, n, i + 1, j);
        floodfill(grid, m, n, i - 1, j);
        floodfill(grid, m, n, i, j + 1);
        floodfill(grid, m, n, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 1}
        };
        System.out.println(numIslands(grid));
    }
}
