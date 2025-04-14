package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximalSquare {

    /**
     * DP way of doing things, 2D dp matrix.
     * TODO: lookout for recursion of brute force method.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N)
     */
    public int maximalSquare(char[][] matrix) {
        int [][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int maxSquareSize = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }

        return maxSquareSize * maxSquareSize;
    }

    /**
     * DP way of doing things, 1D dp matrix (interview friendly).
     *
     * TODO: lookout for recursion of brute force method.
     * @time-complexity - O (M * N).
     * @space-complexity - O (N)
     */
    public int maximalSquare2(char[][] matrix) {
        int [] dp = new int[matrix[0].length + 1];

        int maxSquareSize = 0;

        for (int i = 1; i <= matrix.length; i++) {
            int prev = 0;
            for (int j = 1; j <= matrix[0].length; j++) {
                // Imp since it could be used for matrix value.
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {

                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                    maxSquareSize = Math.max(maxSquareSize, dp[j]);
                }
                prev = temp;
            }
        }

        return maxSquareSize * maxSquareSize;
    }

}
