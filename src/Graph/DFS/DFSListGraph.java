package Graph.DFS;

import Graph.DFS.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DFSListGraph {
    public static void dfsListGraph(List<GraphNode> lists){
        HashSet<GraphNode> visited = new HashSet<>();
        for(GraphNode node : lists){
            if(!visited.contains(node)){
                helper(node, visited);
            }
        }
    }

    private static void helper(GraphNode node, HashSet<GraphNode> visited){
        visited.add(node);
        System.out.println(node.label);
        for(GraphNode neighbor : node.neighbors){
            if(!visited.contains(neighbor)){
                helper(neighbor, visited);
            }
        }
    }
    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(c);
        e.neighbors.add(d);

        b.neighbors.add(a);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        f.neighbors.add(a);

        List<GraphNode> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        lists.add(c);
        lists.add(d);
        lists.add(e);
        lists.add(f);
        dfsListGraph(lists);

    }
}
