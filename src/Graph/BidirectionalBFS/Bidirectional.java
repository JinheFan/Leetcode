package Graph.BidirectionalBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Bidirectional {

    public static int bidirectional(GraphNode start, GraphNode end){
        int res = 0;
        Queue<GraphNode> startQueue = new LinkedList<>();
        HashSet<GraphNode> startSet = new HashSet<>();
        startQueue.offer(start);
        startSet.add(start);

        Queue<GraphNode> endQueue = new LinkedList<>();
        HashSet<GraphNode> endSet = new HashSet<>();
        endQueue.offer(end);
        endSet.add(end);

        while(!startQueue.isEmpty() || !endQueue.isEmpty()){
            int startSize = startQueue.size();
            res++;
            for (int i = 0; i < startSize; i++) {
                 GraphNode node = startQueue.poll();
                 for(GraphNode neighbor : node.neighbors){
                     if(endSet.contains(neighbor)){
                         return res;
                     }
                     if(!startSet.contains(neighbor)){
                         startQueue.offer(neighbor);
                         startSet.add(neighbor);
                     }
                 }
            }

            int endSize = endQueue.size();
            res++;
            for (int i = 0; i < endSize; i++) {
                 GraphNode node = endQueue.poll();
                 for(GraphNode neighbor : node.neighbors){
                     if(startSet.contains(neighbor)){
                         return res;
                     }
                     if(!endSet.contains(neighbor)){
                         endSet.add(neighbor);
                         endQueue.offer(neighbor);
                     }
                 }
            }
        }
        return -1;
    }
}
