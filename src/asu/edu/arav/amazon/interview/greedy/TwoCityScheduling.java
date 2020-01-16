package asu.edu.arav.amazon.interview.greedy;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {

    /**
     * @algo - Greedy
     * @time-complexity - O(NlogN)
     * @space-complexity - O(1)
     */

    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        if (costs == null || costs.length == 0 || costs.length % 2 == 1) {
            return res;
        }
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        for (int i = 0; i < costs.length; i++) {
            if (i >= costs.length / 2) {
                res += costs[i][1];
            } else {
                res += costs[i][0];
            }
        }
        return res;
    }
}
