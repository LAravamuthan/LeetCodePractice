package asu.edu.arav.amazon.interview.design;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/design-search-autocomplete-system/
 */

public class AutocompleteSystem {
    Trie root;

    class WordCountNode {
        String s;
        int count;

        WordCountNode(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    class Trie {
        int count = 0;
        Trie[] childs = new Trie[27];
    }

    public int getInt(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    public void insert(String s, int count) {
        Trie t = root;
        for (int i = 0; i < s.length(); i++) {
            if (t.childs[getInt(s.charAt(i))] != null) {
                t = t.childs[getInt(s.charAt(i))];
            } else {
                t.childs[getInt(s.charAt(i))] = new Trie();
                t = t.childs[getInt(s.charAt(i))];
            }
        }
        t.count += count;
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    public List<WordCountNode> lookup(String s) {
        Trie t = root;
        for (int i = 0; i < s.length(); i++) {
            if (t.childs[getInt(s.charAt(i))] != null) {
                t = t.childs[getInt(s.charAt(i))];
            } else {
                return new ArrayList<>();
            }
        }

        List<WordCountNode> ansList = new ArrayList<>();
        dfsTraversal(t, s, ansList);
        return ansList;
    }

    public void dfsTraversal(Trie t, String sb, List<WordCountNode> ansList) {
        if (t.count > 0) {
            ansList.add(new WordCountNode(sb, t.count));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.childs[i - 'a'] != null) {
                dfsTraversal(t.childs[i - 'a'], sb + i, ansList);
            }
        }
        if (t.childs[26] != null) {
            dfsTraversal(t.childs[26], sb + ' ', ansList);
        }
    }

    String inputStringPreFix = "";

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(inputStringPreFix, 1);
            inputStringPreFix = "";
        } else {
            inputStringPreFix += c;
            List<WordCountNode> wordCountNodes = lookup(inputStringPreFix.toString());
            Collections.sort(wordCountNodes, new Comparator<WordCountNode>() {
                @Override
                public int compare(WordCountNode o1, WordCountNode o2) {
                    return o1.count == o2.count ? o1.s.compareTo(o2.s) : o2.count - o1.count;
                }
            });
            for(int i = 0; i < Math.min(3, wordCountNodes.size()); i++){
                res.add(wordCountNodes.get(i).s);
            }
        }
        return res;
    }
}

