package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BestTimetoBuyandSellStockIV {

    /**
     * Merging the transactions you see.
     *
     * @time-complexity - O(N * (N - K)) -> N - K --> no. of deletion of transactions.
     * @space-complexity - O(N/2)
     */
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices.length <= 0) return 0;

        // first find all the possible transactions
        List<int[]> transactions = new ArrayList<>();

        int start = 0, end = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) end = i;
            else {
                if (end > start) {
                    int[] t = new int[] {start, end};
                    transactions.add(t);
                }
                start = i;
            }
        }

        // Adding last transaction if not already added
        if (end > start) {
            int[] t = new int[] {start, end};
            transactions.add(t);
        }

        // Now while the number of transactions are more than k, trim to k transactions while minimizing the
        // loss of trimming
        while (transactions.size() > k) {

            // First trying finding the min loss of deleting a transaction altogether.
            int minDeletingLoss = Integer.MAX_VALUE;
            int deleteIndex = 0;
            for (int i = 0; i < transactions.size(); i++) {
                int[] transaction = transactions.get(i);
                int currLoss = prices[transaction[1]] - prices[transaction[0]];
                if (currLoss < minDeletingLoss) {
                    minDeletingLoss = currLoss;
                    deleteIndex = i;
                }
            }

            // Next we find min loss in merging any two consecutive transaction at current size of transactions
            int minMergeLoss = Integer.MAX_VALUE;
            int mergeIndex = 0;
            for (int i = 1; i < transactions.size(); i++) {
                int[] transactionCur = transactions.get(i);
                int[] transactionPrev = transactions.get(i - 1);

                int currLoss = prices[transactionPrev[1]] - prices[transactionCur[0]];
                if (currLoss < minMergeLoss) {
                    minMergeLoss = currLoss;
                    mergeIndex = i;
                }
            }

            // Compare the minLoss from merging or deleting transaction.
            if (minDeletingLoss <= minMergeLoss) {
                transactions.remove(deleteIndex);
            } else {
                int[] t1 = transactions.get(mergeIndex - 1);
                int[] t2 = transactions.get(mergeIndex);

                // basic merge operation
                t1[1] = t2[1];
                transactions.remove(mergeIndex);
            }
        }


        int maxProfit = 0;
        for (int [] transaction : transactions) {
            maxProfit += prices[transaction[1]] - prices[transaction[0]];
        }

        return maxProfit;
    }



    /**
     * Multi-dimension DP, one of tricky problems faced by me.
     * TODO: Read this again.
     *
     * @time-complexity - O(N * K).
     * @space-complexity - O(N * K * 2 ~ N*K).
     */
    public int maxProfit2(int k, int[] prices) {
        if (k <= 0 || prices.length <= 0) return 0;

        // k is not index of anything but no. of transaction itself
        // ith day, jth transaction, last dimension is for either buy or sell -> 0 --> doing nothing or selling parse
        // 1 --> acting on it
        int [][][] dp = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        // Base condition
        dp[0][0][0] = 0;
        // first buying action
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int h = 0; h < 2; h++) {
                    // At any point we have two options
                    // either keep previous state, keep holding or keep not holding.
                    // Holding previous state
                    // dp[i][j][0] = dp[i - 1][j][0]
                    // dp[i][j][1] = dp[i - 1][j][1]
                    // Buying now should come from previous transaction from previous day of holding stock
                    // dp[i][j][1] = dp[i - 1][j - 1][0] - prices[i]
                    // Selling should come from current transaction from previous day of acing on stock
                    // dp[i][j][0] = dp[i - 1][j][1] + prices[i]
                    // hence the following logic lets go.
                    if (h == 0) {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    } else {
                        // can not have keep previous state of holding unless we have a single tranaction
                        if (j > 0) {
                            dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0] - prices[i]);
                        }
                    }
                }
            }
        }

        int maxProfit = 0;
        for (int i = 0; i <= k; i++) {
            maxProfit = Math.max(dp[prices.length - 1][i][0], maxProfit);
        }

        return maxProfit;
    }

    /**
     * Simulation method too.
     *
     * @time-complexity - O(N*K).
     * @space-complexity - O(K)
     */
    public int maxProfit3(int k, int[] prices) {
        if (k <= 0 || prices.length <= 0) return 0;

        int [] cost = new int[k + 1];
        int [] profit = new int[k + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        profit[0] = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                cost[j] = Math.min(cost[j], prices[i] - profit[j - 1]);
                profit[j] = Math.max(profit[j], prices[i] - cost[j]);
            }
        }

        return profit[k];
    }
}
