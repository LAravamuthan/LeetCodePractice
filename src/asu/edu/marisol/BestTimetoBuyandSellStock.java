package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BestTimetoBuyandSellStock {

    /**
     * Dynamic Programming iterating from starting index.
     *
     * @time-complexity - O (n), n is size of prices.
     * @space-complexity - O (1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentMinPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] - currentMinPrice > maxProfit) {
                maxProfit = prices[i] - currentMinPrice;
            }

            if (currentMinPrice > prices[i]) {
                currentMinPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
