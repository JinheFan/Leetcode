package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {
    public static void bfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while(!queue.isEmpty()) {
                    int size = queue.size();
                    for(int k = 0; k < size; k++) {
                        int vertix = queue.poll();
                        System.out.println(vertix);
                        for (int j = 0; j < matrix.length; j++) {
                            if(matrix[vertix][j] == 1) {
                                if(visited[j] == 0) {
                                    queue.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        }
                    }
                    System.out.println();
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
        bfsMatrix(matrix);
    }
}
