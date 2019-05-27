package asu.edu.Arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinCostTicket {
    public static int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }
        int[] minCostArray = new int[days.length];
        minCostArray[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < days.length; i++) {
            int cost1 = minCostArray[i - 1] + costs[0];
            int cost2 = minCostArray[i - 1] + costs[1];
            int cost3 = minCostArray[i - 1] + costs[2];
            int j = i - 1;
            while (j >= 0) {
                if (days[i] - days[j] > 30) {
                    break;
                } else if (days[i] - days[j] < 7 && days[i] - days[j] < 30) {
                    cost2 = costs[1] + minCostArray[j];
                    cost2 = j == 0 ? cost2 - minCostArray[j] : cost2 - minCostArray[j] + minCostArray[j - 1];
                    cost3 = costs[2] + minCostArray[j];
                    cost3 = j == 0 ? cost3 - minCostArray[j] : cost3 - minCostArray[j] + minCostArray[j - 1];
                } else if (days[i] - days[j] < 30) {
                    cost2 = costs[1] + minCostArray[j];
                    cost3 = costs[2] + minCostArray[j];
                    cost3 = j == 0 ? cost3 - minCostArray[j] : cost3 - minCostArray[j] + minCostArray[j - 1];
                }
                j--;
            }
            minCostArray[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        return minCostArray[days.length - 1];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7,2,15};
        System.out.println(mincostTickets(days, costs));
    }
}
