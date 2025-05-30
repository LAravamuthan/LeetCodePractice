package asu.edu.marisol;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KeysandRooms {

    /**
     * DFS method.
     *
     * @time-complexity - O(N + E) - work it out pls
     * @space-complexity - O(N) - max recursion level will N depth long only.
     */
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];

        Stack<Integer> st = new Stack<>();
        seen[0] = true;
        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();
            for (int neighbor : rooms.get(node)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    st.push(neighbor);
                }
            }
        }

        for (boolean status : seen) if (!status) return false;
        return true;
    }

    /**
     * DFS method.
     *
     * @time-complexity - O(N + E) - work it out pls
     * @space-complexity - O(N) - max recursion level will N depth long only.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);

        return rooms.size() == visited.size();
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int node) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int neighbor : rooms.get(node)) {
            dfs(rooms, visited, neighbor);
        }
    }
}
