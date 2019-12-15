package asu.edu.arav.amazon.interview.leetcode.module.dynamicprogramming;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - preMin, maxProfit);
            preMin = Math.min(preMin, prices[i]);
        }

        return maxProfit;
    }
}
