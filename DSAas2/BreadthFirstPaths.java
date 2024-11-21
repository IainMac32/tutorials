package DSAas2;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {
    private final boolean[] marked;  
    private final int[] edgeTo;      
    private final int source;        // source vertex
    private final int[] distTo; // distTo[v] = number of edges on shortest path from source

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.source = s;

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Integer.MAX_VALUE;  // Initialize distances to "infinity"
        }

        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        distTo[s] = 0;  // source to itself is 0
        queue.offer(s); // enqueue s

        while (!queue.isEmpty()) {
            int v = queue.poll(); // dequeue v
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v; // path to w
                    distTo[w] = distTo[v] + 1; // distance is now w
                    marked[w] = true;
                    queue.offer(w);   // enqueue w
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.addFirst(x); //push
        }
        path.addFirst(source); //push
        return path;
    }

    public int distTo(int v) {
        return distTo[v];
    }
}