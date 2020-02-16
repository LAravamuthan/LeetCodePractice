package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/stone-game-ii/
 */
public class StoneGameII {
    /**
     * @algo - Dynamic Programming
     * @time-complexity - O(n^2)
     * @space-complexity - O(n^2)
     */
    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) return 0;
        int n = piles.length;
        /* This is making the pile array as summation from right side */
        for (int i = n - 2; i >= 0; i--) piles[i] += piles[i + 1];
        int[][] dp = new int[n][(n + 1) / 2 + 1];
        /* The fact is if there are n - i piles u need minimum m = (n - i + 1)/2
         * to all other piles from it self */
        dp[n - 1][1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            // min m for current n - i elements
            int m = (n - i + 1) / 2;
            int sum = piles[i];
            /* when u ca capture all the piles take all no optimisation required */
            dp[i][m] = sum;
            while (--m > 0) {
                dp[i][m] = 0;
                /* if u cant take all the piles thereafter, then check 1 to 2m options if you choose
                 *  x piles then u get sum (max) - best of dp[i + x][nextoptimal m] */
                for (int x = 1; x <= 2 * m && i + x < n; x++) {
                    int nextOptimalM = Math.min((n - (i + x) + 1) / 2, Math.max(x, m));
                    dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][nextOptimalM]);
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        StoneGameII st = new StoneGameII();
        st.stoneGameII(new int[]{2,7,9,4,4});
    }
}
