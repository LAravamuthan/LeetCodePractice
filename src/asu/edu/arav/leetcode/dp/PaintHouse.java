package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int cost = 0;
        if (costs == null || costs.length == 0) {
            return cost;
        }
        int[] intBestCost = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int[] tempBestCost = new int[3];
            tempBestCost[0] = costs[i][0] + Math.min(intBestCost[1], intBestCost[2]);
            tempBestCost[1] = costs[i][1] + Math.min(intBestCost[0], intBestCost[2]);
            tempBestCost[2] = costs[i][2] + Math.min(intBestCost[1], intBestCost[0]);
            intBestCost = tempBestCost;
        }
        cost = Math.min(intBestCost[0], intBestCost[1]);
        cost = Math.min(cost, intBestCost[2]);
        return cost;
    }
}
