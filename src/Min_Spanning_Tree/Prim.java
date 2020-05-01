package Min_Spanning_Tree;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    public void PrimMST(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        }
        );
        minDist[0] = 0;
        pq.offer(new Pair<Integer, Integer>(minDist[0], 0));
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.lists[vertex];
            for(int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                int destination = edge.end;
                int curDist = edge.weight;
                if(!visited[destination]) {
                    if(curDist < minDist[destination]) {
                        pq.offer(new Pair<>(curDist, destination));
                        minDist[destination] = curDist;
                        parents[destination] = vertex;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);

        Prim prim = new Prim();
        prim.PrimMST(graph);
    }
}
