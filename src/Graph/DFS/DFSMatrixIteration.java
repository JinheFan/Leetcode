package Graph.DFS;

import java.util.Stack;

public class DFSMatrixIteration {
    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                stack.push(i);
                visited[i] = 1;
                while(!stack.isEmpty()) {
                    Integer vertix = stack.pop();
                    System.out.println(vertix);
                    for (int j = 0; j < matrix.length; j++) {
                        if(matrix[vertix][j] == 1) {
                            if(visited[j] == 0) {
                                stack.push(j);
                                visited[j] = 1;
                            }
                        }
                    }
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
        dfsMatrixIteration(matrix);
    }
}
