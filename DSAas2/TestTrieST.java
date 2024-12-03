package DSAas2;

public class TestTrieST {


    
    public static void main(String[] args) {
        TrieST<Integer> trie = new TrieST<>();
        trie.put("apple", 1);
        trie.put("app", 2);
        trie.put("bat", 3);
        trie.put("ball", 4);
        trie.put("cat", 5);
    
        trie.printAllKeys(); // Validate structure
        System.out.println("Size of root: " + trie.size(trie.root)); // Should match total key count
    }
}
