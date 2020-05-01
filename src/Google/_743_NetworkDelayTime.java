package Google;


import java.util.*;
import javafx.util.*;

/**
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * */
public class _743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Graph graph = new Graph(N + 1);
        int[] minDist = new int[N + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[K] = 0;
        boolean[] visited = new boolean[N + 1];
        for(int[] time : times){
            graph.addEdge(time[0], time[1], time[2]);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2){
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        pq.offer(new Pair<Integer, Integer>(minDist[K], K));
        int count = 0;
        while(!pq.isEmpty()){
            Pair<Integer, Integer> pair = pq.poll();
            int vertix = pair.getValue();
            visited[vertix] = true;
            count++;
            for(Edge edge : graph.lists[vertix]){
                int destination = edge.end;
                int curDist = minDist[vertix] + edge.weight;
                if(!visited[destination]){
                    if(curDist < minDist[destination]){
                        minDist[destination] = curDist;
                        pq.offer(new Pair<Integer, Integer>(minDist[destination], destination));
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i < minDist.length; i++){
            max = Math.max(max, minDist[i]);
        }
        return count == N ? max : -1 ;
    }
}

class Edge{
    int start;
    int end;
    int weight;
    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    List<Edge>[] lists;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.lists = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            lists[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight){
        Edge edge = new Edge(start, end, weight);
        lists[start].add(edge);

    }
}
