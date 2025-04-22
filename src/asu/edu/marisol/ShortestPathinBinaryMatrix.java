package asu.edu.marisol;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ShortestPathinBinaryMatrix {

    /**
     * Set rows and cols to zero based on initial setting of row and col heads.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O ()
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;

        // (row, col, level)
        Queue<int[]> queue = new ArrayDeque<>();

        int[] dirs = {-1, 0, 1};


        queue.offer(new int[] {0, 0, 1});
        grid[0][0] = -1;

        while (!queue.isEmpty()) {
            int [] point = queue.poll();

            if (point[0] == n - 1 && point[1] == m - 1) return point[2];

            for (int x : dirs) {
                for (int y : dirs) {
                    if (x == 0 && y == 0) continue;

                    int xn = x + point[0];
                    int yn = y + point[1];

                    if (xn >= 0 && xn < n && yn >= 0 && yn < m && grid[xn][yn] == 0) {
                        queue.offer(new int[] {xn, yn, point[2] + 1});
                        grid[xn][yn] = -1;
                    }
                }
            }
        }

        return -1;
    }
}
