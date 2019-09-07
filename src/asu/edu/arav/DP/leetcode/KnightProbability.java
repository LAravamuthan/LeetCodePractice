package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KnightProbability {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] ir = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] ic = {2, -2, 1, -1, 2, -2, 1, -1};

        dp[r][c] = 1;

        for (; K > 0; K--) {
            double[][] kthProbabilityDp = new double[N][N];
            for (int lr = 0; lr < N; lr++) {
                for (int lc = 0; lc < N; lc++) {
                    for (int k = 0; k < 8; k++) {
                        int nr = lr + ir[k];
                        int nc = lc + ic[k];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N)
                            kthProbabilityDp[nr][nc] += dp[lr][lc] / 8.0;
                    }
                }
            }
            dp = kthProbabilityDp;
        }
        double ans = 0.0;
        for (double rows[] : dp) {
            for (double col : rows) {
                ans += col;
            }
        }
        return ans;
    }
}
