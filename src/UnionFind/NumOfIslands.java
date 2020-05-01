package UnionFind;

public class NumOfIslands {
    static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int countNum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        UnionFind uf = new UnionFind(m * n);
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    num++;
                    for(int[] dir : dirs) {
                        int curX = dir[0] + i;
                        int curY = dir[1] + j;
                        if(isValid(matrix, curX, curY)) {
                            uf.union(i * n + j, curX * n + curY);
                        }
                    }
                }
            }
        }
        return num - uf.sum;
    }

    private static boolean isValid(int[][] matrix, int i, int j) {
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 1, 1}
        };
        System.out.println(countNum(matrix));
    }
}
