package asu.edu.marisol;

public class BestTimetoBuyandSellStockIII {

    /**
     * 1p array travering from both sides i.e left subsequence answer and right subsequence maxProfit,
     * run it through all partition i.e at i = 0  to i = n - 1.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(2N ~ N)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;

        int leftMin = prices[0];
        int rightMax = prices[n - 1];

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n + 1];

        for (int i = 1; i < n; i++) {

            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);

            int rightIndex = n - 1 - i;
            rightProfit[rightIndex] = Math.max(rightProfit[rightIndex + 1], rightMax - prices[rightIndex]);
            rightMax = Math.max(prices[rightIndex], rightMax);

        }

        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(leftProfit[i] + rightProfit[i + 1], maxProfit);
        }

        return maxProfit;
    }


    /**
     * Simulation algorithm pretty cool but be careful here.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(1)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // two this we here cost of first transaction  and cost of second transaction.
        // Mind you both don't happen on the same day even if they that way.
        // always second set of cost and profit for the second interaction is made of out of proper minCost and
        // max Profit for previous transaction so chill and don't lose your mind.

        int t1cost = Integer.MAX_VALUE, t2cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;

        for (int i = 0; i < prices.length; i++) {
            t1cost = Math.min(t1cost, prices[i]);
            t1Profit = Math.max(t1Profit, prices[i] - t1cost);

            t2cost = Math.min(t2cost, prices[i] - t1Profit);
            t2Profit = Math.max(t2Profit, prices[i] - t2cost);
        }

        return t2Profit;
    }



}
