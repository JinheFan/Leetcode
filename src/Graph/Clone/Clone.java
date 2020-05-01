package Graph.Clone;

import java.util.*;

public class Clone {
    static HashMap<GraphNode, GraphNode> map = new HashMap<>();
    public static void clone(GraphNode node) {
        if(node == null) {
            return;
        }
        GraphNode dup = helper(node);

        List<Integer> res = new ArrayList<>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(dup);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode cur = queue.poll();
                res.add(cur.val);
                for(GraphNode neighbor : cur.neighbors) {
                    queue.offer(neighbor);
                }
            }
        }
        System.out.print(Arrays.toString(res.toArray()));
    }

    private static GraphNode helper(GraphNode node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        GraphNode dup = new GraphNode(node.val);
        map.put(node, dup);
        for(GraphNode neighbor : node.neighbors) {
            GraphNode clone = helper(neighbor);
            map.get(node).neighbors.add(clone);
        }
        return dup;
    }

    public static void main(String[] args) {
        GraphNode root = new GraphNode(1);
        GraphNode g1 = new GraphNode(2);
        GraphNode g2 = new GraphNode(3);
        root.neighbors.add(g1);
        root.neighbors.add(g2);

        clone(root);
    }
}
