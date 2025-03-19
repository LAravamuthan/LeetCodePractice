package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BestTimetoBuyandSellStockII {

    /**
     *
     * Simple approach, read and learn but find why it works.
     *
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    /**
     * Different approach, valley peak approach whenever you see valley and peak transact.
     *
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */
    public int maxProfit1(int[] prices) {
        int profit = 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }

    /**
     * Trying all combination, for sure not optimal but challenging to coding.
     *
     * @time-complexity - O(N^N)
     * @space-complexity - O(N)
     */
    public int maxProfit2(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int[] prices, int startIdx) {
        if (startIdx >= prices.length) return 0;
        int max = 0;
        for(int i = startIdx; i < prices.length - 1; i++) {
            int maxProfitAtI = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if (profit > maxProfitAtI)
                        maxProfitAtI = profit;
                }
            }
            if (max < maxProfitAtI) max = maxProfitAtI;
        }
        return max;
    }



}
