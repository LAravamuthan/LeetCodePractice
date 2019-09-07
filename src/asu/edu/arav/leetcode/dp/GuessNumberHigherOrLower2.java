package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class GuessNumberHigherOrLower2 {

    public int getMoneyAmount(int n) {
        int[][] costMatrix = new int[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i_index = 1; i_index <= n - len; i_index++) {
                int mCostForSomeInterval = Integer.MAX_VALUE;
                for (int pivot_index = i_index + (len / 2); pivot_index <= i_index + len - 1; pivot_index++) {
                    int costOfIntervalWithPivot = pivot_index + Math.max(costMatrix[i_index][pivot_index - 1],
                            costMatrix[pivot_index + 1][i_index + len]);
                    mCostForSomeInterval = Math.min(mCostForSomeInterval, costOfIntervalWithPivot);
                }
                costMatrix[i_index][i_index + len] = mCostForSomeInterval;
            }
        }
        return costMatrix[1][n];
    }
}
