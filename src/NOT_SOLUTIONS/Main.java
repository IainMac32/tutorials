package src.NOT_SOLUTIONS;

public class Main {
    public static void main(String[] args) {
        WeightedQuickUF uf = new WeightedQuickUF(10);

        // Create a tree of height 3 by connecting 0 -> 1 -> 2 -> 3
        uf.union(0, 1);  // Union 0 and 1 (height 0 -> 1)
        uf.union(1, 2);  // Union 1 and 2 (height 1 -> 2)
        uf.union(2, 3);  // Union 2 and 3 (height 2 -> 3)

        // Create a tree of height 2 by connecting 4 -> 5 -> 6
        uf.union(4, 5);  // Union 4 and 5 (height 0 -> 1)
        uf.union(5, 6);  // Union 5 and 6 (height 1 -> 2)
        uf.union(6, 7);  // Union 5 and 6 (height 1 -> 2)

        // Union the two trees (root at 0 with height 3, root at 4 with height 2)
        uf.union(3, 6);

        // Print the height of the resulting tree after the union
        System.out.println("Height of the tree containing node 0 (after union): " + uf.heightTree(0));  // Should reflect the height after union
        System.out.println("Height of the tree containing node 6 (after union): " + uf.heightTree(6));  // Should be the same as the height of node 0, since they are now connected
    }
}
