package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestIncreasingPathinaMatrix {

    /**
     * DFS Cache approach to make sure to are linear time complexity instead of exponential time complexity.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (m * n).
     */
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
        this.cache = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(i, j));

        return ans;
    }

    private int[][] matrix;
    private int[][] cache;
    private int m, n;
    private static final int[][] DIRS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private int dfs(int row, int col) {
        if (cache[row][col] != 0) return cache[row][col];

        for (int[] dir: DIRS) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && matrix[nrow][ncol] > matrix[row][col]) {
                cache[row][col] = Math.max(cache[row][col], dfs(nrow, ncol));
            }
        }

        return ++cache[row][col];
    }


    /**
     * Topological sort to be done here should be the one used in interview lets a attempt.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (m * n).
     */
    public int longestIncreasingPath2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m + 2][n + 2];
        int[][] inDegree = new int[m + 2][n + 2];

        for (int i = 0; i < m; i++)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                for (int[] dir: DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (matrix[i][j] < matrix[x][y])
                        inDegree[x][y]++;
                }
            }
        }

        List<int[]> leaves = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (inDegree[i][j] == 0) leaves.add(new int[] {i, j});
            }
        }

        int dist = 0;
        while (!leaves.isEmpty()) {
            dist++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int [] leaf : leaves) {
                for (int[] dir : DIRS) {
                    int neighborX = leaf[0] + dir[0];
                    int neighborY = leaf[1] + dir[1];
                    if (matrix[neighborX][neighborY] > matrix[leaf[0]][leaf[1]]) {
                        inDegree[neighborX][neighborY]--;
                        if (inDegree[neighborX][neighborY] == 0)
                            newLeaves.add(new int[] {neighborX, neighborY});
                    }
                }
            }
            leaves = newLeaves;
        }

        return dist;
    }

}
