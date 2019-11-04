package asu.edu.arav.amazon.interview.design;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class AutocompleteSystemPrc {
    class WordCountNode {
        String word;
        int count;

        WordCountNode(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    Trie root = new Trie();

    class Trie {
        Map<Character, Trie> childs = new HashMap<>();
        int count;
    }

    public void insert(String s, int count) {
        Trie t = root;
        for (int i = 0; i < s.length(); i++) {
            if (t.childs.get(s.charAt(i)) == null) {
                t.childs.put(s.charAt(i), new Trie());
            }
            t = t.childs.get(s.charAt(i));
        }
        t.count += count;
    }

    public AutocompleteSystemPrc(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }


    public List<WordCountNode> lookup(String s) {
        Trie t = root;
        for (int i = 0; i < s.length(); i++) {
            if (t.childs.get(s.charAt(i)) == null) {
                return new ArrayList<>();
            }
            t = t.childs.get(s.charAt(i));
        }
        List<WordCountNode> wcns = new ArrayList<>();
        dfsTraversal(s, t, wcns);
        return wcns;
    }

    public void dfsTraversal(String s, Trie t, List<WordCountNode> wcns) {
        if (t.count > 0) {
            wcns.add(new WordCountNode(s, t.count));
        }
        for (char ch : t.childs.keySet()) {
            dfsTraversal(s + ch, t.childs.get(ch), wcns);
        }
    }

    public List<String> getTopHitWords(List<WordCountNode> wcns, int k) {
        List<String> suggestions = new ArrayList<>();
        PriorityQueue<WordCountNode> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.word.compareTo(b.word)
                : b.count - a.count);
        for (WordCountNode wcn : wcns) {
            pq.offer(wcn);
        }


        for (int i = 0; i < Math.min(wcns.size(), k); i++) {
            suggestions.add(pq.poll().word);
        }
        return suggestions;
    }

    String ins = "";

    public List<String> input(char c) {
        List<String> suggestions = new ArrayList<>();
        if (c == '#') {
            insert(ins, 1);
            ins = "";
        } else {
            ins = ins + c;
            List<WordCountNode> wcns = lookup(ins);
            suggestions = getTopHitWords(wcns, 3);
        }
        return suggestions;
    }
}
