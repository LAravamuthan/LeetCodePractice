package asu.edu.marisol;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RottingOranges {

    /**
     * BFS approach here.
     *
     * @time-complexity - O (NM).
     * @space-complexity - O (NM).
     */
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int freshOranges = 0, time = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) freshOranges++;
                else if (grid[i][j] == 2) queue.offer(i * n + j);
            }
        }

        while (!queue.isEmpty() && freshOranges > 0) {
            time++;
            for (int level = queue.size(); level > 0; level--) {
                int element = queue.poll();
                int row = element / n, col = element % n;

                for (int[] dir : DIRS) {
                    int nrow = row + dir[0], ncol = col + dir[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        freshOranges--;
                        queue.offer(nrow * n + ncol);
                    }
                }
            }
        }

        return freshOranges == 0 ? time : -1;
    }

    private static final int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, 1}};

}
