package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BuyAndSellWithFee {

    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int currBuy = Math.max(buy, sell - prices[i]);
            int currSell = Math.max(sell, buy + prices[i] - fee);
            buy = currBuy;
            sell = currSell;
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] in = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(in, 2));
    }

}
