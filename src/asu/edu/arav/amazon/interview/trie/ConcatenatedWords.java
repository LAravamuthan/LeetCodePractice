package asu.edu.arav.amazon.interview.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/concatenated-words/
 */


public class ConcatenatedWords {


    /**
     * @algo - Trie and DFS
     * @time-complexity - O()
     * @space-complexity - O()
     */

    class Trie {
        boolean isWord = false;
        Map<Character, Trie> children = new HashMap<>();
    }

    Trie root = null;
    List<String> ans = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0) return ans;
        root = new Trie();
        for (String word : words) {
            Trie t = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (t.children.get(ch) == null) {
                    t.children.put(ch, new Trie());
                }
                t = t.children.get(ch);
            }
            t.isWord = true;
        }
        for (String word : words) {
            if (isConcatenatedWord(word)) ans.add(word);
        }
        return ans;
    }

    public boolean isConcatenatedWord(String s) {
        return dfsHelper(0, s, 0, root);
    }

    public boolean dfsHelper(int idx, String s, int count, Trie cur) {
        boolean result = false;
        if (idx == s.length()) return result;
        cur = cur.children.get(s.charAt(idx));
        if(cur == null) return result;
        if (cur.isWord) {
            if (idx == s.length() - 1 && count > 0) return true;
            result = dfsHelper(idx + 1, s, count + 1, root);
        }
        return result || dfsHelper(idx + 1, s, count, cur);
    }

}
