package DSAas2;


public class TrieSTnoo2<Value> {
    private static final int R = 256; // Radix
    private Node root; // Root of trie
    private int size = 0; // Number of keys in the trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    // Get the value associated with the given key
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    // Put a key-value pair into the trie
    public void put(String key, Value val) {
        if (val == null) return;
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null) size++;
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }





    
    // Floor: Largest key less than or equal to the given key
    public String floor(String key) {
        return floor(root, key, "", 0);
    }

    private String floor(Node x, String key, String prefix, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) return prefix;
            return maxKey(x, prefix);
        }
        char c = key.charAt(d);
        if (x.next[c] != null) {
            String candidate = floor(x.next[c], key, prefix + c, d + 1);
            if (candidate != null) return candidate;
        }
        for (char i = (char) (c - 1); i >= 0; i--) {
            if (x.next[i] != null) {
                return maxKey(x.next[i], prefix + i);
            }
        }
        if (!prefix.isEmpty()) {
            return floor(root, key.substring(0, prefix.length() - 1), "", 0);
        }
        return null;
    }

    private String maxKey(Node x, String prefix) {
        if (x == null) return null;
        for (char c = R - 1; c >= 0; c--) {
            if (x.next[c] != null) {
                String candidate = maxKey(x.next[c], prefix + c);
                if (candidate != null) return candidate;
            }
        }
        if (x.val != null) return prefix;
        return null;
    }





    // Ceiling: Smallest key greater than or equal to the given key
    public String ceiling(String key) {
        return ceiling(root, key, "", 0);
    }

    private String ceiling(Node x, String key, String prefix, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) return prefix;
            return minKey(x, prefix);
        }
        char c = key.charAt(d);
        for (char i = c; i < R; i++) {
            if (x.next[i] != null) {
                String candidate = ceiling(x.next[i], key, prefix + i, d + 1);
                if (candidate != null) return candidate;
            }
        }
        return null;
    }

    private String minKey(Node x, String prefix) {
        if (x == null) return null;
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                String candidate = minKey(x.next[c], prefix + c);
                if (candidate != null) return candidate;
            }
        }
        if (x.val != null) return prefix;
        return null;
    }





    // Rank: Number of keys less than the given key
    public int rank(String key) {
        return rank(root, key, 0);
    }

    private int rank(Node x, String key, int d) {
        if (x == null) return 0;
        if (d == key.length()) return count(x);
        char c = key.charAt(d);
        int rank = 0;
        for (char i = 0; i < c; i++) {
            rank += count(x.next[i]);
        }
        rank += rank(x.next[c], key, d + 1);
        return rank;
    }

    private int count(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;
        for (char c = 0; c < R; c++) {
            cnt += count(x.next[c]);
        }
        return cnt;
    }





    // Select: Key of the given rank
    public String select(int k) {
        return select(root, k, "");
    }

    private String select(Node x, int k, String prefix) {
        if (x == null) return null;
        if (k < 0) return null;
        if (x.val != null) {
            if (k == 0) return prefix;
            k--;
        }
        for (char c = 0; c < R; c++) {
            int count = count(x.next[c]);
            if (k < count) return select(x.next[c], k, prefix + c);
            k -= count;
        }
        return null;
    }

    // Size
    public int size() {
        return size;
    }
}
