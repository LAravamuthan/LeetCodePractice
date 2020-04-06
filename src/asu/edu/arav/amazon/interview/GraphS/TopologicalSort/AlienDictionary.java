package asu.edu.arav.amazon.interview.GraphS.TopologicalSort;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {

    Map<Character, Set<Character>> charEdges = new HashMap<>();
    Map<Character, Integer> inDegreeMap = new HashMap<>();
    String[] words = null;

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        this.words = words;

        // Initiallising the indegrees of the possible characters in the alien dictionary
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegreeMap.put(c, 0);
            }
        }
        buildGraph();
        StringBuilder sb = bfsTopologicalSort();


        return sb.length() == inDegreeMap.size() ? sb.toString() : "";
    }

    public void buildGraph() {
        // iterate all the words in the list of string
        // make the indegree and edges Map
        for (int i = 0; i < this.words.length - 1; i++) {
            // the point to remember is the fact that word1 and word2 are arranged
            // lexicographically
            String word1 = this.words[i];
            String word2 = this.words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            // compare till its possible, as the smallest size among the two words is the
            // length till which we can compare
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    Set<Character> c1Set = charEdges.getOrDefault(c1, new HashSet<Character>());
                    if (!c1Set.contains(c2)) { // add only if already not present or else indegree calculation will go wrong
                        c1Set.add(c2);
                        inDegreeMap.put(c2, inDegreeMap.get(c2) + 1);// indegree of c2 increased
                        charEdges.put(c1, c1Set);
                    }
                    // this breaking is important as we can just consider the first non matching
                    // character, the character after that cant be compared as their order does not matter
                    break;
                }
            }
        }
    }


    public StringBuilder bfsTopologicalSort() {
        Queue<Character> queue = new ArrayDeque<Character>();
        for (char c : inDegreeMap.keySet()) {
            // if the indegree is 0 it is the of the highest order right not
            if (inDegreeMap.get(c) == 0) {
                queue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (charEdges.containsKey(c)) {
                for (char child : charEdges.get(c)) {
                    inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                    if (inDegreeMap.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        return sb;
    }


}
