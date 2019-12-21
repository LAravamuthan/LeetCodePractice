package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        if (arr.length == 2) {
            return arr[0] * arr[1];
        }
        int n = arr.length;
        int max[][] = new int[n][n];
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            int maxFromI = 0;
            for (int j = i; j < n; j++) {
                if (maxFromI < arr[j]) {
                    maxFromI = arr[j];
                }
                max[i][j] = maxFromI;
            }
        }

        for (int length = 1; length < n; length++) {
            for (int leftS = 0; leftS + length < n - 1; leftS++) {
                int rights = leftS + length;
                dp[leftS][rights] = Integer.MAX_VALUE;
                if (length == 1) {
                    dp[leftS][rights] = arr[leftS] * arr[rights];
                } else {
                    for (int k = leftS; k < rights; k++) {
                        dp[leftS][rights] = Math.min(dp[leftS][rights], dp[leftS][k] + dp[k + 1][rights] +
                                max[leftS][k] * max[k + 1][rights]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

}
