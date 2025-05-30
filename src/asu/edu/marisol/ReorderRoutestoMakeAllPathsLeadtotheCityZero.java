package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

    /**
     * DFS approach.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(1).
     */
    public int minReorder(int n, int[][] connections) {
        this.count = 0;
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(Arrays.asList(connection[0], 1));
        }

        dfs(adj, 0, -1);
        return count;
    }

    private int count;

    private void dfs(Map<Integer, List<List<Integer>>> adj, int node, int parent) {

        for(List<Integer> edge : adj.getOrDefault(node, new ArrayList<>())) {
            int neighbor = edge.get(0), sign = edge.get(1);
            if (neighbor != parent) {
                count += sign;
                dfs(adj, neighbor, node);
            }
        }
    }

}
