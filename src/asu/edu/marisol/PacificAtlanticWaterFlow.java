package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PacificAtlanticWaterFlow {

    /**
     * BFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (N*M).
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        Queue<int[]> bfsQueuePacific = new ArrayDeque<>();
        Queue<int[]> bfsQueueAtlantic = new ArrayDeque<>();

        int m = heights.length, n = heights[0].length;


        for (int row = 0; row < m; row++) {
            bfsQueuePacific.offer(new int[] {row, 0});
            bfsQueueAtlantic.offer(new int[] {row, n - 1});
        }

        for (int col = 0; col < n; col++) {
            bfsQueuePacific.offer(new int[] {0, col});
            bfsQueueAtlantic.offer(new int[] {m - 1, col});
        }
        boolean[][] pacificReach = bfs(heights, bfsQueuePacific);
        boolean[][] atlanticReach = bfs(heights, bfsQueueAtlantic);

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (pacificReach[row][col] && atlanticReach[row][col])
                    ans.add(Arrays.asList(row, col));
            }
        }

        return ans;
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean[][] bfs(int[][] heights, Queue<int[]> bfsQueue) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] oceanReach = new boolean[rows][cols];

        while(!bfsQueue.isEmpty()) {
            int[] node = bfsQueue.poll();
            int row = node[0], col = node[1];
            oceanReach[row][col] = true;

            for (int[] dir : DIRS) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && !oceanReach[nrow][ncol]
                        && heights[nrow][ncol] >= heights[row][col])
                    bfsQueue.offer(new int[] {nrow, ncol});
            }
        }

        return oceanReach;
    }

    /**
     * DFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (N*M).
     */
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean [][] pacificReach = new boolean[m][n], atlanticReach = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            dfs(heights, pacificReach, row, 0);
            dfs(heights, atlanticReach, row, n - 1);
        }

        for (int col = 0; col < n; col++) {
            dfs(heights, pacificReach, 0, col);
            dfs(heights, atlanticReach, m - 1, col);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (pacificReach[row][col] && atlanticReach[row][col])
                    ans.add(Arrays.asList(row, col));
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] oceanReach, int row, int col) {
        if (oceanReach[row][col]) return;
        oceanReach[row][col] = true;
        int rows = heights.length, cols = heights[0].length;

        for (int[] dir : DIRS) {
            int nrow = row + dir[0], ncol = col + dir[1];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && heights[nrow][ncol] >= heights[row][col])
                dfs(heights, oceanReach, nrow, ncol);
        }

    }


}
