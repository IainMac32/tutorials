package DSAas2;

public class TrieST<Value> {
    private static int R = 256; // radix
    private Node root; // root of trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
        private int count; // add to track size of subtree
        //rest of the trieST is from the textbook
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) { // Return value associated with key in the subtrie rooted at x.
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null){
            x = new Node();
        } 

        if (d == key.length()) {
            if (x.val == null){
                x.count++; // new key added
            } 
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        int oldSize = size(x.next[c]); // size of subtree before the put
        x.next[c] = put(x.next[c], key, val, d + 1);
        int newSize = size(x.next[c]); // updated size
        x.count += (newSize - oldSize); // get new count
        return x;
    }


    //my functions 
    public String floor(String key) {
        return floor(root, key, "", null, 0);
    }
    
    private String floor(Node x, String key, String prefix, String best, int d) {
        if (x == null) return best;
    
        if (x.val != null && prefix.compareTo(key) <= 0) {
            best = prefix; // update best
        }
    
        if (d == key.length()) {
            return best; // return the best if no more chars to see
        }
    
        char c = key.charAt(d);
    
        // look at smaller characters first for a better candidate
        for (int cc = c - 1; cc >= 0; cc--) {
            if (x.next[cc] != null) {
                String candidate = floor(x.next[cc], key, prefix + (char) cc, best, d + 1);
                if (candidate != null) {
                    best = candidate;
                }
            }
        }
    
        // look at exact character of the key
        if (x.next[c] != null) {
            best = floor(x.next[c], key, prefix + c, best, d + 1);
        }
    
        return best;
    }


    public String ceiling(String key) {
        return ceiling(root, key, "", null, 0);
    }
    
    private String ceiling(Node x, String key, String prefix, String best, int d) {
        if (x == null) return best;
    
        if (x.val != null && prefix.compareTo(key) >= 0) {
            best = prefix; // update best 
        }
    
        if (d == key.length()) {
            return best; // return the best if no more chars to see
        }
    
        char c = key.charAt(d);
    
        // look at exact character of the key
        if (x.next[c] != null) {
            best = ceiling(x.next[c], key, prefix + c, best, d + 1);
        }
    
        // look at larger characters for a better candidate
        for (int cc = c + 1; cc < R; cc++) {
            if (x.next[cc] != null) {
                String candidate = ceiling(x.next[cc], key, prefix + (char) cc, best, d + 1);
                if (candidate != null) {
                    best = candidate;
                }
            }
        }
    
        return best;
    }                            
    

    private int size(Node x) {
        if (x == null){
            return 0;
        } 
        return x.count;
    } //helper for rank and select


    public int rank(String key) {
        return rank(root, key, 0);
    }

    private int rank(Node x, String key, int d) {
        if (x == null){
            return 0;
        } 
        if (d == key.length()){
            return 0; // only less than not equal to so return 0
        } 
        char c = key.charAt(d);
        int sum = 0;
        for (int f = 0; f < c; f++) {
            // total size of the subtrees from children of x node
            if (x.next[f] != null){
                sum += size(x.next[f]);
            } 
        }
        return sum + rank(x.next[c], key, d + 1);
    }
    
    
    public String select(int rank) {
        return select(root, rank, "");
    }

    private String select(Node x, int rank, String prefix) {
        if (x == null){
            return null;
        } 
        if (rank == 0 && x.val != null){ //base case
            return prefix;
        } 
        int sum = 0;
        for (int g = 0; g < R; g++) { //loop through ASCII amount
            if (x.next[g] != null) {
                int count = size(x.next[g]);
                if (sum + count > rank) {
                    return select(x.next[g], rank - sum, prefix + (char) g);
                    //recurse with new node and rank
                }
                sum += count;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TrieST<Integer> trie = new TrieST<>();
        trie.put("apple", 1);
        trie.put("app", 2);
        trie.put("bat", 3);
        trie.put("ball", 4);
        trie.put("cat", 5);
    
        System.out.println(trie.floor("bat"));   
        System.out.println(trie.ceiling("ba")); 

        System.out.println(trie.rank("ball")); 
        System.out.println(trie.select(0)); 
    
    }
}