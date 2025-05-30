package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ShortestBridge {

    /**
     * Lets check how to do this and go forward.
     *
     * @time-complexity - O (n^2).
     * @space-complexity - O (n^2).
     */
    public int shortestBridge(int[][] grid) {
        this.bfsQueue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;

        search: for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    break search;
                }
            }
        }

        int minDistance = 0;

        while (!bfsQueue.isEmpty()) {
            for (int i = bfsQueue.size(); i > 0; i--) {
                int [] node = bfsQueue.poll();
                for (int[] dir : DIRS) {
                    int nrow = node[0] + dir[0], ncol = node[1] + dir[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                        if (grid[nrow][ncol] == 0) {
                            bfsQueue.offer(new int[] {nrow, ncol});
                            grid[nrow][ncol] = -1;
                        }
                        if (grid[nrow][ncol] == 1)
                            return minDistance;
                    }
                }
            }
            minDistance++;
        }


        return minDistance;
    }

    private Queue<int[]> bfsQueue;
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int row, int col, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        grid[row][col] = 2;
        bfsQueue.offer(new int[] {row, col});
        for (int[] dir : DIRS) {
            int nrow = row + dir[0], ncol = col + dir[1];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1)
                dfs(nrow, ncol, grid);
        }
    }
}
