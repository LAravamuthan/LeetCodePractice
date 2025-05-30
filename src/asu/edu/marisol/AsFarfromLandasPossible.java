package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AsFarfromLandasPossible {

    /**
     * DP without extra space, lets try.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (1).
     */
    public int maxDistance(int[][] grid) {
        int ans = Integer.MIN_VALUE, m = grid.length, n = grid[0].length;
        int MAX_DIST = m + n - 1;


        // Taking left and top element as reference.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    grid[i][j] = 0;
                else {
                    grid[i][j] = MAX_DIST;
                    grid[i][j] = Math.min(grid[i][j], Math.min(
                            i - 1 >= 0 ? grid[i - 1][j] + 1 : MAX_DIST,
                            j - 1 >= 0 ? grid[i][j - 1] + 1 : MAX_DIST
                    ));
                }
            }
        }

        // Taking right and lower element as reference.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j], Math.min(
                        i + 1 < m ? grid[i + 1][j] + 1 : MAX_DIST,
                        j + 1 < n ? grid[i][j + 1] + 1 : MAX_DIST
                ));
                ans = Math.max(ans, grid[i][j]);
            }
        }

        return ans == 0 || ans == MAX_DIST ? -1 : ans;
    }


    /**
     * BFS lets try it.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int maxDistance2(int[][] grid) {
        int ans = -1, m = grid.length, n = grid[0].length;

        Queue<int[]> bfsQueue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    bfsQueue.offer(new int[] {i, j});
            }
        }

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for (int level = 0; level < size; level++) {
                int[] node = bfsQueue.poll();
                for (int [] dir : DIRS) {
                    int nrow = node[0] + dir[0], ncol = node[1] + dir[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0) {
                        grid[nrow][ncol] = 1;
                        bfsQueue.offer(new int[] {nrow, ncol});
                    }
                }
            }
            ans++;
        }

        return ans == 0 ? -1 : ans;
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

}
