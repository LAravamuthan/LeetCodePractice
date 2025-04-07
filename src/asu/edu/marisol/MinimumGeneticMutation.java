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
     * Recursion and binary search concept
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
}
