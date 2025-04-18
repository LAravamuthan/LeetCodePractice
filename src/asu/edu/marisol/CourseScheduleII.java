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
public class CourseScheduleII {

    /**
     * DFS traversal back edge check and finding order.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (n + m).
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[] {0};
        this.inStack = new boolean[numCourses];
        this.visited = new boolean[numCourses];
        this.adjEdges = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();
        this.cyclePresent = false;

        for (int[] prerequisite : prerequisites) {
            List<Integer> edges = adjEdges.getOrDefault(prerequisite[1], new ArrayList<>());
            edges.add(prerequisite[0]);
            adjEdges.put(prerequisite[1], edges);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) dfsOrder(i);
        }

        int [] answer;

        if (this.cyclePresent) {
            answer = new int[0];
        } else {
            answer = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                answer[i] = topologicalOrder.get(numCourses - 1 - i);
            }
        }

        return answer;
    }

    private boolean[] inStack;
    private boolean[] visited;
    private Map<Integer, List<Integer>> adjEdges;
    private List<Integer> topologicalOrder;
    private boolean cyclePresent;


    private void dfsOrder (int node) {
        if (inStack[node]) {
            this.cyclePresent = true;
            return;
        }

        if (visited[node]) {
            return;
        }

        this.inStack[node] = true;
        this.visited[node] = true;

        for (int neighbor : adjEdges.getOrDefault(node, new ArrayList<>())) {
            dfsOrder(neighbor);
        }

        this.inStack[node] = false;
        this.topologicalOrder.add(node);
    }


    /**
     * BFS traversal topological sort kahn algo.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (n + m).
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[] {0};

        Map<Integer, List<Integer>> adjEdges = new HashMap<>();
        int [] inDegree = new int[numCourses];

        for (int [] prerequisite : prerequisites) {
            List<Integer> edges = adjEdges.getOrDefault(prerequisite[1], new ArrayList<>());
            edges.add(prerequisite[0]);
            adjEdges.put(prerequisite[1], edges);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                order.add(i);
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor : adjEdges.getOrDefault(node, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    order.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        int [] answer;
        if (order.size() == numCourses) {
            answer = new int[numCourses];
            for (int i = 0; i < numCourses; i++) answer[i] = order.get(i);
        } else {
            answer = new int[0];
        }

        return answer;
    }

}
