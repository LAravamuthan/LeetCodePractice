package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CourseSchedule {

    /**
     * DFS traversal, with back edge check.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (n + m).
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        this.inStack = new boolean[numCourses];
        this.visited = new boolean[numCourses];
        this.adjacentEdges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adjacentEdges.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            adjacentEdges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(dfs(i)) return false;
        }

        return true;
    }

    private boolean[] inStack;
    private boolean[] visited;
    private List<List<Integer>> adjacentEdges;

    private boolean dfs(int node) {
        if (inStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        inStack[node] = true;

        for (int childNode : adjacentEdges.get(node)) {
            if (dfs(childNode)) return true;
        }

        inStack[node] = false;
        return false;
    }


    /**
     * DFS traversal, with back edge check.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (n + m).
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;

        Map<Integer, List<Integer>> adjEdges = new HashMap<>();
        int [] inDegree = new int[numCourses];

        for (int [] prerequisite : prerequisites) {
            List<Integer> edges = adjEdges.getOrDefault(prerequisite[1], new ArrayList<>());
            edges.add(prerequisite[0]);
            adjEdges.put(prerequisite[1], edges);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int visitedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visitedNodes++;
            for (int neighbor : adjEdges.getOrDefault(node, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visitedNodes == numCourses;
    }

}
