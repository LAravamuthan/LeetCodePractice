package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */

public class StoneGame {
    public static boolean stoneGame(int[] piles) {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
            }

        return dp[1][N] > 0;
    }

    public static void main(String[] args) {
        int [] input = {3,2,10,4};
        System.out.println(stoneGame(input));
    }
}
