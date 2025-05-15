package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AlienDictionary {

    /**
     * BFS, topological sort, Kahn's algorithm.
     * TODO: TC analysis looks involved.
     *
     * @time-complexity - O (C) all characters in the all words,
     * @space-complexity - O (1).
     */
    public String alienOrder(String[] words) {
        this.adjEdges = new HashMap<>();
        this.counts = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray())
                counts.putIfAbsent(ch, 0);
        }

        for (int i = 0; i + 1 < words.length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    adjEdges.computeIfAbsent(word1.charAt(j), k -> new ArrayList<>()).add(word2.charAt(j));
                    break;
                }
            }
        }

        Queue<Character> q = new ArrayDeque<>();

        for (char ch : counts.keySet())
            if (counts.get(ch) == 0) q.offer(ch);

        StringBuilder order = new StringBuilder();

        while(!q.isEmpty()) {
            char node = q.poll();
            order.append(node);

            for (char child : adjEdges.getOrDefault(node, new ArrayList<>())) {
                counts.put(child, counts.get(child) - 1);
                if (counts.get(child) == 0) q.offer(child);
            }
        }

        return order.length() != counts.keySet().size() ? "" : order.toString();
    }

    private Map<Character, List<Character>> adjEdges;
    private Map<Character, Integer> counts;


    /**
     * DFS approach to find the order, the adjEdges will be in dependency order.
     *
     * @time-complexity - O (C) all characters in the all words,
     * @space-complexity - O (1).
     */
    public String alienOrder2(String[] words) {
        this.visited = new HashSet<>();
        this.stack = new HashSet<>();
        this.dependencies = new HashMap<>();

        for (String word : words)
            for (char ch : word.toCharArray())
                if (!dependencies.containsKey(ch)) dependencies.put(ch, new ArrayList<>());


        for (int i = 0; i + 1 < words.length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    dependencies.computeIfAbsent(word2.charAt(j), k -> new ArrayList<>()).add(word1.charAt(j));
                    break;
                }
            }
        }

        StringBuilder order =  new StringBuilder();

        //dfs on for order
        for (char ch : dependencies.keySet()) {
            if (!dfsCheck(ch, order))
                return "";
        }

        return order.toString();
    }

    private Map<Character, List<Character>> dependencies;
    private Set<Character> visited;
    private Set<Character> stack;

    private boolean dfsCheck(char node, StringBuilder order) {
        if (visited.contains(node)) return true;
        if (stack.contains(node)) return false;

        stack.add(node);

        for (char child : dependencies.get(node))
            if(!dfsCheck(child, order))
                return false;

        visited.add(node);
        stack.remove(node);
        order.append(node);

        return true;
    }

}
