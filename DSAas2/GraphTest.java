package DSAas2;

public class GraphTest {
    public static void main(String[] args) {
        // Step 1: Create a simple graph
        Graph G = new Graph(6);  // Create a graph with 6 vertices
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 5);
        G.addEdge(4, 5);

        // Step 2: Create a BreadthFirstPaths object starting from vertex 0
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);

        // Step 3: Test distTo method for various vertices
        System.out.println("Distance from 0 to 0: " + bfs.distTo(0));  // Expected: 0
        System.out.println("Distance from 0 to 1: " + bfs.distTo(1));  // Expected: 1
        System.out.println("Distance from 0 to 2: " + bfs.distTo(2));  // Expected: 1
        System.out.println("Distance from 0 to 3: " + bfs.distTo(3));  // Expected: 2
        System.out.println("Distance from 0 to 4: " + bfs.distTo(4));  // Expected: 2
        System.out.println("Distance from 0 to 5: " + bfs.distTo(5));  // Expected: 3
    }
}
