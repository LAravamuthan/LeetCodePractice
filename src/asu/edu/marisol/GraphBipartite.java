package asu.edu.marisol;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GraphBipartite {

    /**
     * DFS approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n)
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Stack<Integer> st = new Stack<>();
                st.push(i);
                color[i] = 0;
                while (!st.isEmpty()) {
                    int node = st.pop();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            st.push(neighbor);
                            color[neighbor] = color[node] ^ 1;
                        }
                        else if (color[neighbor] == color[node])
                            return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * DFS approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n)
     */
    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfsColor(graph, color, i, 0))
               return false;
        }
        return true;
    }

    private boolean dfsColor(int[][] graph, int[] color, int node, int currentColor) {
        color[node] = currentColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfsColor(graph, color, neighbor, currentColor ^ 1)) return false;
            } else if (color[neighbor] == color[node]) return false;
        }

        return true;
    }

}
