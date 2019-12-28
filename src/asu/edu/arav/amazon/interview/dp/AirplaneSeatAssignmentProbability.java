package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/airplane-seat-assignment-probability/
 */
public class AirplaneSeatAssignmentProbability {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }

    // dp solution T - O(n) and S - O(n)
    public double nthPersonGetsNthSeat2(int n) {

        double[] dp = new double[n];
        dp[0] = 1.0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1.0 / (i + 1) + dp[i - 1] * (i - 1) / (i + 1);
        }
        return dp[n - 1];
    }
}
