package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

    class TrieNode {
        private Map<Character, TrieNode> children;
        private String word;

        public TrieNode() {
            children = new HashMap<>();
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public TrieNode getNode(Character ch) {
            return children.get(ch);
        }

        public void removeNode(Character ch) {
            children.remove(ch);
        }

        public void addChar(Character ch) {
            if (!children.containsKey(ch))
                children.put(ch, new TrieNode());
        }
    }

    private void addWordToTrieNode(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.addChar(ch);
            node = node.getNode(ch);
        }
        node.setWord(word);
    }

    List<String> ans = new ArrayList<>();
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            addWordToTrieNode(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.getNode(board[row][col]) != null)
                    findMatches(board, row, col, root);
            }
        }

        return ans;
    }

    private void findMatches(char[][] board, int r, int c, TrieNode node) {
        TrieNode child = node.getNode(board[r][c]);
        if (child.getWord() != null) {
            ans.add(child.word);
            child.setWord(null);
        }
        char temp = board[r][c];
        board[r][c] = '#';

        int [][] dirs = { {0, -1}, {-1, 0}, {0, 1},  {1, 0}};
        for (int[] dir : dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                continue;
            } else {
                if (child.getNode(board[row][col]) != null)
                    findMatches(board, row, col, child);
            }
        }
        board[r][c] = temp;

        if (child.getChildren().isEmpty()) {
            node.getChildren().remove(board[r][c]);
        }
    }
}
