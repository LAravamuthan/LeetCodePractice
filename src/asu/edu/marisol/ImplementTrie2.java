package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ImplementTrie2 {

    TrieNode root;

    public ImplementTrie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.getChild(ch) == null) {
                node.setChild(ch);
            }
            node = node.getChild(ch);
        }
        node.setWord();
    }

    public boolean search(String word) {
        TrieNode node = startsWithNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = startsWithNode(prefix);
        return node != null;
    }

    private TrieNode startsWithNode(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.getChild(ch);
            if (node == null) return null;
        }

        return node;
    }



    class TrieNode {

        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public void setChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord() {
            isWord = true;
        }
    }
}
