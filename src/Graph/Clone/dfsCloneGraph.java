package Graph.Clone;

import java.util.HashMap;

public class dfsCloneGraph {
    static HashMap<GraphNode, GraphNode> map = new HashMap<>();

    public static GraphNode clone(GraphNode node) {
        return helper(node);
    }

    private static GraphNode helper(GraphNode node) {
        if(node == null) return null;
        if(map.containsKey(node)) {
            return map.get(node);
        }
        GraphNode dup = new GraphNode(node.val);
        map.put(node, dup);
        for(GraphNode neighbor : node.neighbors) {
            GraphNode clone = helper(neighbor);
            dup.neighbors.add(clone);
        }
        return map.get(node);
    }
}
