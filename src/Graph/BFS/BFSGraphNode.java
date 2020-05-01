package Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphNode {
    public static void bfs(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 GraphNode curNode = queue.poll();
                 for(GraphNode neighbor : curNode.neighbors){
                     if(visited.add(neighbor)){
                         queue.offer(neighbor);
                     }
                 }
            }
        }
    }
}
