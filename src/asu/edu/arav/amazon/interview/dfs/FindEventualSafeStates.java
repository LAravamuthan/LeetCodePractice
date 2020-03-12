package asu.edu.arav.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-eventual-safe-states/
 */
public class FindEventualSafeStates {

    /**
     * @algo - DFS
     * @time-complexity - O(n)
     * @space-complexity - O(n) - worst case
     */

    List<Integer> ans = new ArrayList<>();
    int[] color = null;
    int[][] graph = null;

    public List<Integer> eventualSafeNodes(int[][] graph) {

        if (graph == null || graph.length == 0) return ans;
        color = new int[graph.length];
        this.graph = graph;

        for (int i = 0; i < graph.length; i++) {
            if (dfsCycleCheck(i)) ans.add(i);
        }

        return ans;
    }

    public boolean dfsCycleCheck(int node) {
        if (color[node] > 0) return color[node] == 2;

        color[node] = 1;
        for (int child : graph[node]) {
            if (color[child] == 2) continue;
            if (color[child] == 1 || !dfsCycleCheck(child)) return false;
        }
        color[node] = 2;
        return true;
    }

}
