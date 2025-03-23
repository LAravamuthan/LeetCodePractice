package asu.edu.marisol;

public class ImplementTrie {
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if (node.get(ch) == null) {
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setWordEnd(true);
    }

    public boolean search(String word) {
        TrieNode startsWithNode = startsWithNode(word);
        return startsWithNode != null && startsWithNode.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        return startsWithNode(prefix) != null;
    }

    public TrieNode startsWithNode(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            node = node.get(ch);
            if (node == null) return null;
        }
        return node;
    }

    class TrieNode {
        private TrieNode[] children;
        private boolean isWordEnd = false;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public void put(Character ch) {
            if (!containsKey(ch)) children[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(Character ch) {
            return children[ch - 'a'];
        }

        public boolean isWordEnd() {
            return isWordEnd;
        }

        public void setWordEnd(boolean wordEnd) {
            isWordEnd = wordEnd;
        }
    }
}
