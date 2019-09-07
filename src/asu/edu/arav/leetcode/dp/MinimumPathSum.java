package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];

        for (int i = grid[0].length - 2; i >= 0; i--) {
            dp[grid.length - 1][i] = dp[grid.length - 1][i + 1] + grid[grid.length - 1][i];
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = dp[i + 1][grid[0].length - 1] + grid[i][grid[0].length - 1];
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    public int minPathSum1(int[][] grid) {
        int[] dp = new int[grid.length];
        for (int j = grid[0].length - 1; j >= 0; j--) {
            for (int i = grid.length - 1; i >= 0; i--) {
                if(i == grid.length - 1 && j == grid[0].length - 1){
                    dp[i] = grid[i][j];
                }else if(i == grid.length - 1 && j != grid[0].length - 1){
                    dp[i] = grid[i][j] + dp[i];
                }else if(i != grid.length - 1 && j == grid[0].length - 1){
                    dp[i] = grid[i][j] + dp[i+1];
                }else{
                    dp[i] = grid[i][j] + Math.min(dp[i + 1], dp[i]);
                }
            }
        }
        return dp[0];
    }
}
