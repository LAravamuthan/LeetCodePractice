package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumGeneticMutation {

    /**
     * BFS search.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        int steps = 0;

        char [] charSet =  {'A', 'C', 'G', 'T'};
        Queue<String> q = new ArrayDeque<>();
        q.offer(startGene);

        Set<String> seen = new HashSet<>();

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                String node = q.poll();
                if (node.equals(endGene));
                for (int j = 0; j < node.length(); j++) {
                    for (char ch : charSet) {
                        String newNode = node.substring(0, j) + ch + node.substring(j + 1);
                        if (Arrays.asList(bank).contains(newNode) && !seen.contains(newNode)) {
                            q.offer(newNode);
                            seen.add(newNode);
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }


    /**
     * BFS search approach, but practicing now.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public int minMutation2(String startGene, String endGene, String[] bank) {
        int steps = 0;
        char[] charSet = {'A', 'C', 'G', 'T'};
        Set<String> seen = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(startGene);
        seen.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int level = 0; level < size; level++) {
                String node = queue.poll();
                if (node.equals(endGene)) return steps;

                for (int i = 0; i < node.length(); i++) {
                    char oldChar = node.charAt(i);
                    for (char ch : charSet) {
                        if (ch != oldChar) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(node);
                            sb.setCharAt(i, ch);
                            String newNode = sb.toString();
                            if (!seen.contains(newNode) && bankSet.contains(newNode)) {
                                queue.offer(newNode);
                                seen.add(newNode);
                            }
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
