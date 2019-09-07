package asu.edu.arav.impgoogle;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
@SuppressWarnings("Duplicates")
public class BestBuySellCoolDown {


    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        if (prices == null || prices.length == 0) {
            return 0;
        }

        buy[0] = -prices[0];
        sell[0] = 0;


        for (int i = 1; i < prices.length; i++) {
            if (i - 2 < 0) {
                buy[i] = Math.max(buy[i - 1], 0 - prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit1(int[] prices) {


        if (prices == null || prices.length == 0) {
            return 0;
        }

        int b1 = -prices[0];
        int s1 = 0;
        int s2 = 0;


        for (int i = 1; i < prices.length; i++) {
            int b0 = Math.max(b1, s2 - prices[i]);
            int s0 = Math.max(s1, b1 + prices[i]);
            s2 = s1;
            s1 = s0;
            b1 = b0;
        }
        return s1;
    }

}
