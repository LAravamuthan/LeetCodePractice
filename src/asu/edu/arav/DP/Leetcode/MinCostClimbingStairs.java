package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] result = new int[cost.length];
        result[0] = cost[0];
        result[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            result[i] = Math.min(cost[i] + result[i - 1], cost[i] + result[i - 2]);
        }
        return Math.min(result[cost.length - 1], result[cost.length - 2]);
    }
}
