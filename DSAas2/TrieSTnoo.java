package DSAas2;


import java.util.ArrayList;
import java.util.List;

public class TrieST<Value> {
    private static final int R = 256; // radix
    private Node root; // root of trie
    private int size = 0; // Number of keys in the Trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null)
            x = new Node();
        if (d == key.length()) {
            if (x.val == null) size++; // Increment size for a new key
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return size;
    }

    // Collect all keys in sorted order
    public Iterable<String> keys() {
        List<String> result = new ArrayList<>();
        collect(root, new StringBuilder(), result);
        return result;
    }

    private void collect(Node x, StringBuilder prefix, List<String> result) {
        if (x == null) return;
        if (x.val != null) result.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }




    
    // Floor: Largest key less than or equal to the given key
    public String floor(String key) {
        return floor(root, key, new StringBuilder(), null, 0);
    }

    private String floor(Node x, String key, StringBuilder prefix, String best, int d) {
        if (x == null) return best;
        if (d == key.length()) {
            if (x.val != null) return prefix.toString();
            return best;
        }
        char c = key.charAt(d);
        if (c > 0) {
            best = floor(x.next[c - 1], key, new StringBuilder(prefix).append((char) (c - 1)), best, d + 1);
        }
        if (x.val != null && prefix.toString().compareTo(key) <= 0) {
            best = prefix.toString();
        }
        return floor(x.next[c], key, prefix.append(c), best, d + 1);
    }





    // Ceiling: Smallest key greater than or equal to the given key
    public String ceiling(String key) {
        return ceiling(root, key, new StringBuilder(), 0);
    }

    private String ceiling(Node x, String key, StringBuilder prefix, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) return prefix.toString();
            return nextKey(x, prefix);
        }
        char c = key.charAt(d);
        String next = ceiling(x.next[c], key, prefix.append(c), d + 1);
        if (next != null) return next;
        prefix.deleteCharAt(prefix.length() - 1);
        for (char cc = (char) (c + 1); cc < R; cc++) {
            if (x.next[cc] != null) {
                prefix.append(cc);
                return nextKey(x.next[cc], prefix);
            }
        }
        return null;
    }

    private String nextKey(Node x, StringBuilder prefix) {
        if (x == null) return null;
        if (x.val != null) return prefix.toString();
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                prefix.append(c);
                return nextKey(x.next[c], prefix);
            }
        }
        return null;
    }




    // Rank: Number of keys less than the given key
    public int rank(String key) {
        return rank(root, key, 0, 0);
    }

    private int rank(Node x, String key, int d, int count) {
        if (x == null) return count;
        if (d == key.length()) return count;
        char c = key.charAt(d);
        for (char cc = 0; cc < c; cc++) {
            count += size(x.next[cc]);
        }
        return rank(x.next[c], key, d + 1, count);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int count = 0;
        if (x.val != null) count++;
        for (char c = 0; c < R; c++) {
            count += size(x.next[c]);
        }
        return count;
    }






    // Select: Return the key at the given rank (0-based)
    public String select(int rank) {
        return select(root, rank, new StringBuilder());
    }

    private String select(Node x, int rank, StringBuilder prefix) {
        if (x == null) return null;
        if (x.val != null) {
            if (rank == 0) return prefix.toString();
            rank--;
        }
        for (char c = 0; c < R; c++) {
            int size = size(x.next[c]);
            if (rank < size) {
                prefix.append(c);
                return select(x.next[c], rank, prefix);
            }
            rank -= size;
        }
        return null;
    }
}
