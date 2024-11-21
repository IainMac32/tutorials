package DSAas2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    private final int V;  // number of vertices
    private final List<Integer>[] adj;  // adjacency list

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];  // Initialize adjacency list
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);  // Since the graph is undirected
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }
}
