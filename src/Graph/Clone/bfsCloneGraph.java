package Graph.Clone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class bfsCloneGraph {
    public static GraphNode bfsClone(GraphNode node) {
        if(node == null) return null;
        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();

        queue.offer(node);
        GraphNode dup = new GraphNode(node.val);
        map.put(node, dup);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode curNode = queue.poll();
                for(GraphNode neighbor : curNode.neighbors) {
                    if(!map.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        GraphNode dupNeighbor = new GraphNode(neighbor.val);
                        map.put(neighbor, dupNeighbor);
                    }
                    map.get(curNode).neighbors.add(map.get(neighbor));
                }
            }
        }
        return map.get(node);
    }
}
