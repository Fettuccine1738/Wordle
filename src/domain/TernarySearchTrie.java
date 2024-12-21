package domain;

public class TernarySearchTrie {

    private static final boolean VALID = true;
    private static final boolean INVALID = false;

    private Node root;

    public TernarySearchTrie() {

    }

    public void put(String word) {
        if (word.isEmpty()) throw new IllegalArgumentException("Empty string");
        root = put(root, word, VALID, 0);
    }

    private Node put(Node node, String word, boolean value, int index) {
        char c = word.charAt(index);
        if (node == null) {
            node = new Node();
            node.character = c;
        }
        if (c < node.character) node.left = put(node.left, word, value, index);
        else if (c > node.character) node.right = put(node.right, word, value, index);
        else if (index < word.length() - 1) {
            node.middle = put(node.middle, word, value, index + 1);
        }
        else  node.value = VALID;
        return node;
    }

    public boolean search(String word) {
        if (word.isEmpty()) throw new IllegalArgumentException("Empty string");
        Node current = get(root, word, 0);
        if (current == null) return INVALID;
        return current.value;
    }

    private Node get(Node node, String word, int index) {
        if (node == null) return null;
        char c = word.charAt(index);
        if (c < node.character) return get(node.left, word, index);
        else if (c > node.character) return get(node.right, word, index);
        else if (index < word.length() - 1) return get(node.middle, word, index + 1);
        else return  node;
    }

    private static class Node {
        private boolean value;
        private char character;
        private Node left, middle, right;

        public Node() {
            value = INVALID;
        }
    }

    public static void main(String[] args) {
        TernarySearchTrie trie = new TernarySearchTrie();
        String s1 = "for";
        String s2 = "cook";
        trie.put(s1);
        trie.put(s2);
        System.out.println(trie.search("cook"));
        System.out.println(trie.search("for"));
        System.out.println(trie.search("cooked"));
        System.out.println(trie.search(s2));

    }

}
