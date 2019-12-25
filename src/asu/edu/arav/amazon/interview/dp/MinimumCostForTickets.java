package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        // min cost of buying travel tickets till ith index
        int[] dp = new int[days.length];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < days.length; i++) {
            int cost1 = 0, cost2 = 0, cost3 = 0;
            cost1 = costs[0] + dp[i - 1];
            cost2 = costs[1] + dp[i - 1];
            cost3 = costs[2] + dp[i - 1];
            // Initialise with maximum costs
            // the above are the cost for making the trip on ith day using
            // costs[0], or costs[1] or costs[2]
            for (int j = i - 1; j >= 0; j--) {
                if (days[i] - days[j] < 7){
                    cost2 = costs[1] + (j == 0 ? 0 : dp[j - 1]);
                }
                if (days[i] - days[j] < 30){
                    cost3 = costs[2] + (j == 0 ? 0 : dp[j - 1]);
                }
            }
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        return dp[days.length - 1];
    }
}
