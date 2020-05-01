package Graph.DFS;

        import java.util.HashSet;
        import java.util.Stack;

public class DFSIteration {
    public static void dfsIteration(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);                // visited和stack 放在一起
        while(!stack.isEmpty()) {
            GraphNode curNode = stack.pop();
            for(GraphNode neighbor : curNode.neighbors) {
                if(!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);		// visited和stack 放在一起
                }
            }
        }
    }
}
