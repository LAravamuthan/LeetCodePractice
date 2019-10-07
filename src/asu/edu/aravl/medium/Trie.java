package asu.edu.aravl.medium;

import asu.edu.aravl.utility.TrieNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = startsPreFix(word);
        return node != null && node.isEnd();
    }

    /** Starts with utility */
    public TrieNode startsPreFix(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = startsPreFix(prefix);
        return node != null;
    }
}
