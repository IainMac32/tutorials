package src.NOT_SOLUTIONS;
 //works!!! 
 //do pseudo code though!!

public class WeightedQuickUF {
    private int[] id;
    private int[] height;
    private int count;
    // initialize
    public WeightedQuickUF(int n){
        count = n;
        id = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
            height[i] = 0;
        }
    }
    // get the count of trees
    public int count(){
        return count;
    }
    // see if two nodes are connected
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    // finds a root;
    public int find(int p){
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    // link two nodes together
    public void union(int p, int q){
        int rootTreeP = find(p);
        int rootTreeQ = find(q);
        if (rootTreeP == rootTreeQ){
            return;
        }
        // make smaller root point to larger one
        if (height[rootTreeP] < height[rootTreeQ]){
            id[rootTreeP] = rootTreeQ;
        }
        else if (height[rootTreeP] > height[rootTreeQ]){
            id[rootTreeQ] = rootTreeP;
        }
        else {
            id[rootTreeP] = rootTreeQ; // Make rootTreeQ the new root
            height[rootTreeQ]++;
        }
        count--;
    }
    // OPTIONAL: return the height of the tree
    public int heightTree(int n){
        int nRoot = find(n);
        return height[nRoot];
    }
}
