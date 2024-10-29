package src.NOT_SOLUTIONS.WQU;

public class WeightedQuickUnion {

    private int[] parent;   // Parent of each node
    private int[] size;     // Size of each tree (used to keep trees balanced)
    private int count;      // Number of components

    public WeightedQuickUnion(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the root of the node
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // Path compression
            p = parent[p];
        }
        return p;
    }

    // Union of two components
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        // Make the smaller tree point to the larger tree
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    // Returns the number of components
    public int count() {
        return count;
    }

    // Calculate binomial coefficient "n choose k"
    public static int binomialCoeff(int n, int k) {
        if (k > n) return 0;
        int res = 1;
        if (k > n - k) k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // Print number of nodes at each level in the worst-case tree (binomial coefficients)
    public static void printNodesAtEachLevel(int n) {
        System.out.println("Nodes at each level for n = " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.println("Level " + i + ": " + binomialCoeff(n, i) + " nodes");
        }
    }

    public static void main(String[] args) {
        int n = 16;  // Number of elements in the union-find structure
        WeightedQuickUnion wqu = new WeightedQuickUnion(n);

        // Performing union operations to create the worst-case scenario
        for (int i = 0; i < n / 2; i++) {
            wqu.union(i, i + n / 2);
        }
        for (int i = 1; i < n / 2; i++) {
            wqu.union(i - 1, i);
        }

        // Assuming worst-case structure, print binomial coefficients for the levels
        int treeHeight = (int) (Math.log(n) / Math.log(2));  // Approximate height in worst case
        printNodesAtEachLevel(treeHeight);
    }
}
