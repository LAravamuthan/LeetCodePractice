package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure {

    class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode () {
            children = new HashMap<>();
        }

        public void addCharacter(char ch) {
            if (!children.containsKey(ch)) {
                children.put(ch, new TrieNode());
            }
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public TrieNode getNode(char ch) {
            return children.get(ch);
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    TrieNode root;

    /**
     * Efficient approach, O(n) approach.
     *
     * @time-complexity - O ().
     * @space-complexity - O (1).
     */
    public DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.addCharacter(ch);
            node = node.getNode(ch);
        }
        node.setWord(true);
    }


    private boolean searchInNodes(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.getChildren().containsKey(ch)) {
                if (word.charAt(i) == '.') {
                    for (TrieNode eachChild : node.getChildren().values()) {
                        if (searchInNodes(word.substring(i + 1), eachChild))
                            return true;
                    }
                } 
                return false;
            } else {
                node = node.getNode(ch);
            }
        }
        return node.isWord;
    }

    public boolean search(String word) {
        return searchInNodes(word, root);
    }
}
