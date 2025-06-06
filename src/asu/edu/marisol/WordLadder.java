package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
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
public class WordLadder {

    /**
     * BFS search bidirectional lets do it dude.
     *
     * TODO: Pls read this code again, understand how to set the level values.
     *
     * @time-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<Pair<String, Integer>> frontQ = new ArrayDeque<>();
        Queue<Pair<String, Integer>> backQ = new ArrayDeque<>();
        Map<String, Integer> visitedFront = new HashMap<>();
        Map<String, Integer> visitedBack = new HashMap<>();

        frontQ.offer(new Pair<>(beginWord, 1));
        backQ.offer(new Pair<>(endWord, 0));

        visitedFront.put(beginWord, 1);
        visitedBack.put(endWord, 0);

        while (!frontQ.isEmpty() && !backQ.isEmpty()) {
            if (frontQ.size() > backQ.size()) {
                Queue<Pair<String, Integer>> tempQ = frontQ;
                frontQ = backQ;
                backQ = tempQ;

                Map<String, Integer> tempVisited = visitedFront;
                visitedFront = visitedBack;
                visitedBack = tempVisited;
            }
            int levelSize = frontQ.size();

            for (int i = 0; i < levelSize; i++) {
                Pair<String, Integer> p = frontQ.poll();
                String node = p.getKey();
                int moves = p.getValue();

                if (visitedBack.containsKey(node)) return moves + visitedBack.get(node);

                for (int j = 0; j < node.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        char newChar = (char) ('a' + k);
                        String newNode = node.substring(0, j) + newChar + node.substring(j + 1);
                        if (!visitedFront.containsKey(newNode) && wordSet.contains(newNode)) {
                            frontQ.offer(new Pair<>(newNode, moves + 1));
                            visitedFront.put(newNode, moves + 1);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
