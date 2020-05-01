package ShortestPath.Dijkstra;

import java.util.Arrays;

public class DijkstraMatrix {

    public static int dijkstra(int[][] matrix){
        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        int[] minDist = new int[vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for(int i = 0; i < vertices; i++){
            int vertix = getMin(minDist, visited);
            visited[vertix] = true;
            for(int j = 0; j < vertices; j++){
                if(!visited[j] && matrix[vertix][j] != 0){
                    int curDist = minDist[vertix] + matrix[vertix][j];
                    if(curDist < minDist[j]){
                        minDist[j] = curDist;
                    }
                }
            }
        }
        return minDist[vertices - 1];
    }

    private static int getMin(int[] minDist, boolean[] visited){
        int vertix = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < minDist.length; i++){
            if(!visited[i] && minDist[i] < min){
                min = minDist[i];
                vertix = i;
            }
        }
        return vertix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 3, 5, 0, 0},
                {3, 0, 0, 0, 2},
                {5, 0, 0, 1, 6},
                {0, 0, 1, 0, 7},
                {0, 2, 6, 7, 0}
        };
        System.out.println(dijkstra(matrix));
    }
}
