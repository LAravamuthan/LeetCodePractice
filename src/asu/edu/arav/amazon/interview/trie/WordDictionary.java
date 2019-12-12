package asu.edu.arav.amazon.interview.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {

    class TrieNode {
        // the children map for each character for the current triNode obj
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode itrTrieNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!itrTrieNode.children.containsKey(word.charAt(i))) {
                itrTrieNode.children.put(word.charAt(i), new TrieNode());
            }
            itrTrieNode = itrTrieNode.children.get(word.charAt(i));
        }
        itrTrieNode.isWord = true;
    }

    public boolean recurSearch(String word, TrieNode nodeToStart) {
        TrieNode itrTrieNode = nodeToStart;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Character child : itrTrieNode.children.keySet()) {
                    if (i == word.length() - 1) {
                        if(itrTrieNode.children.get(child).isWord) return true;
                        continue;
                    }
                    if(recurSearch(word.substring(i + 1), itrTrieNode.children.get(child))){
                        return true;
                    }
                }
                return false;
            } else {
                if (itrTrieNode.children.containsKey(word.charAt(i))) {
                    itrTrieNode = itrTrieNode.children.get(word.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return itrTrieNode.isWord;
    }


    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return recurSearch(word, root);
    }


    public static void main(String [] args){
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");wd.addWord("and");wd.addWord("add");wd.addWord("an");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
    }
}
