package asu.edu.arav.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {
    // first segregate the pacific and atlantic points starting points of the DFS and then DFS

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> ansLift = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ansLift;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        // visited coordinates from pacific points
        boolean[][] pacificVisited = new boolean[n][m];
        // visited coordinates from atlantic points
        boolean[][] atlanticVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            // row wise points
            dfs(i, 0, Integer.MIN_VALUE, matrix, pacificVisited);
            dfs(i, m - 1, Integer.MIN_VALUE, matrix, atlanticVisited);
        }

        for (int i = 0; i < m; i++) {
            // column wise points
            dfs(0, i, Integer.MIN_VALUE, matrix, pacificVisited);
            dfs(n - 1, i, Integer.MIN_VALUE, matrix, atlanticVisited);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // the point was reachable by pacific and atlantic points
                // add that to answers le
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    ansLift.add(point);
                }
            }
        }

        return ansLift;
    }

    public void dfs(int row, int col, int height, int[][] matrix, boolean[][] visited) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (row < 0 || row > n - 1 || col < 0 || col > m - 1 || height > matrix[row][col] || visited[row][col]) {
            return;
        }
        // if this coordinate is possible to reach then mark it visited
        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], matrix[row][col], matrix, visited);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        pawf.pacificAtlantic(matrix);
    }

}
