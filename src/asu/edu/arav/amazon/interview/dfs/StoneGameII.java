package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/stone-game-ii/
 */

public class StoneGameII {

    /**
     * @algo - dfs
     * @time-complexity - O()
     * @space-complexity - O()
     */

    int[][] dp;
    // piles right summed
    int[] piles;

    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) return 0;
        int n = piles.length;
        dp = new int[n][(n + 1) / 2 + 1];
        for (int i = n - 2; i >= 0; i--) piles[i] += piles[i + 1];
        this.piles = piles;
        return dfsStyle(n, 0, 1);
    }

    public int dfsStyle(int n, int idx, int m) {
        // base condition if u can take all remaining take it
        if (idx + (2 * m) >= n) {
            return piles[idx];
        }
        // if the current value has already been calculted go ahead
        if (dp[idx][m] > 0) return dp[idx][m];
        int min = Integer.MAX_VALUE;
        /* or else try all possible tiles you can take and choose the best option */
        for (int i = 1; i <= 2 * m && idx + i < n; i++) {
            min = Math.min(min, dfsStyle(n, idx + i, Math.max(i, m)));
        }
        dp[idx][m] = piles[idx] - min;
        return dp[idx][m];
    }

}
