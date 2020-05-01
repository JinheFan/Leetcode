package ShortestPath.Dijkstra;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void dijkstra(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return  key1 - key2;
            }
        });

        pq.offer(new Pair<>(minDist[0], 0));
        while(!pq.isEmpty()){
            Pair<Integer, Integer> pair = pq.poll();
            int vertix = pair.getValue();
            visited[vertix] = true;
            List<Edge> list = graph.lists[vertix];
            for(int i = 0; i < list.size(); i++){
                Edge edge = list.get(i);
                int destination = edge.end;
                int curDist = minDist[vertix] + edge.weight;
                if(!visited[destination]){
                    if(curDist < minDist[destination]){
                        pq.offer(new Pair<>(curDist, destination));
                        minDist[destination] = curDist;
                    }
                }

            }
        }
        for(int i = 0; i < minDist.length; i++) {
            System.out.print("TO" + i + ":" + "Distance is" + minDist[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);

        dijkstra(graph);

    }
}
