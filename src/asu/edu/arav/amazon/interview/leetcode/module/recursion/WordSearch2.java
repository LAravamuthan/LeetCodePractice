package asu.edu.arav.amazon.interview.leetcode.module.recursion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {

    class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        String word = null;
    }

    List<String> resultList = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie rootTrie = new Trie();
        // putting all elements in side the trie DataStructure
        for (String word : words) {
            Trie t = rootTrie;
            for (char ch : word.toCharArray()) {
                if (!t.children.containsKey(ch)) {
                    t.children.put(ch, new Trie());
                }
                t = t.children.get(ch);
            }
            // at the lowest level put this word , this absolutely what we want
            t.word = word;
        }

        // once we have made the trie structure we would dfs style search for words in
        // board that are there in dict given using trie we just made

        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                if(rootTrie.children.containsKey(board[i][j]))dfsStyleboardSearch(board, i, j, rootTrie);
            }
        }
        return resultList;
    }

    public void dfsStyleboardSearch(char[][] board, int row, int col, Trie parent) {
        // get the current node using the parent Trie
        char letter = board[row][col];
        Trie curTrie = parent.children.get(letter);
        if (curTrie.word != null) {
            resultList.add(curTrie.word);
            curTrie.word = null; // this is to make sure that result list does not have
            // duplicates as the wordDict given to us did not have duplicates
        }


        // try out combination the moves you can do from current board charater
        int[] rows = {0, -1, 0, 1};
        int[] cols = {1, 0, -1, 0};
        board[row][col] = '#'; //this is important so that we dont form a loop among the ancestors
        if (!curTrie.children.isEmpty()) {
            for (int i = 0; i < rows.length; i++) {
                int nrow = row + rows[i];
                int ncol = col + cols[i];
                if (nrow < 0 || nrow > board.length - 1 || ncol < 0 || ncol > board[0].length - 1) {
                    continue;
                }
                char nextLetter = board[nrow][ncol];
                if (curTrie.children.get(nextLetter) != null) {
                    dfsStyleboardSearch(board, nrow, ncol, curTrie);
                }
            }
        }
        else{
            // further when the current trie has no children then we saw this for the last time because
            // it is not in board we are searching but the trie trie has only one parent!!! correct??
            // lets see !! yep thats right
            parent.children.remove(letter);
        }

        // once all the possible position of board from current position in board has been explored
        // we make it avaiable to be used by other depth search from other parents
        board[row][col] = letter;

    }


//  public boolean dfs() {}

}
