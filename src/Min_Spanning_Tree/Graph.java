package Min_Spanning_Tree;

import java.util.ArrayList;
        import java.util.List;

public class Graph {
    public List<Edge>[] listsS;
    int vertices;
    List<Edge>[] lists;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.lists = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            lists[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight){
        Edge edge = new Edge(start, end, weight);
        lists[start].add(edge);

        edge = new Edge(end, start, weight);
        lists[end].add(edge);
    }
}
