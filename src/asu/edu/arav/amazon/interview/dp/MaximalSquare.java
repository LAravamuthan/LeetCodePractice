package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    /**
     * @algo - Dp
     * @time-complexity - O(n^2)
     * @space-complexity - O(n^2)
     */

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int u = i - 1 < 0 ? 0 : dp[i - 1][j];
                    int l = j - 1 < 0 ? 0 : dp[i][j - 1];
                    int ac = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(u, Math.min(l, ac)) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
