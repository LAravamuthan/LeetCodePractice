package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumPathSum {

    /**
     * Dynamic programming bottom-up approach..
     *
     * @time-complexity - O (n * m).
     * @space-complexity - O (n * m).
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = grid[r][c];
                    continue;
                }
                int topSum = r > 0 ? dp[r - 1][c] : Integer.MAX_VALUE;
                int leftSum = c > 0 ? dp[r][c - 1] : Integer.MAX_VALUE;

                dp[r][c] = Math.min(topSum, leftSum) + grid[r][c];
            }
        }

        return dp[rows - 1][cols - 1];
    }


    /**
     * Dynamic programming bottom-up approach, but this one optimized to use O(n) space
     *
     * @time-complexity - O (n * m).
     * @space-complexity - O (m)  where m - no. of cols
     */
    public int minPathSum2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[] = new int[cols];

        dp[0] = grid[0][0];

        for (int col = 1; col < cols; col++) {
            dp[col] = dp[col - 1] + grid[0][col];
        }

        for (int r = 1; r < rows; r++) {
            dp[0] += grid[r][0];
            for (int c = 1; c < cols; c++) {
                dp[c] = Math.min(dp[c], dp[c - 1]) + grid[r][c];
            }
        }

        return dp[cols - 1];
    }

    /**
     * Dynamic programming bottom-up approach, but this one optimized to use O(1) space
     *
     * @time-complexity - O (n * m).
     * @space-complexity - O (1).
     */
    public int minPathSum3(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int col = 1; col < cols; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int r = 1; r < rows; r++) {
            grid[r][0] += grid[r - 1][0];
            for (int c = 1; c < cols; c++) {
                grid[r][c] = Math.min(grid[r - 1][c], grid[r][c - 1]) + grid[r][c];
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
