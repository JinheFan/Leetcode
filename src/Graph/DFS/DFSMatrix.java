package Graph.DFS;

public class DFSMatrix {
    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    public static void helper(int[][] matrix, int[] visited, int vertix) {
        visited[vertix] = 1;
        System.out.println(vertix);
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[vertix][i] == 1) {
                if(visited[i] == 0) {
                    helper(matrix, visited, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };
        dfsMatrix(matrix);
    }
}
