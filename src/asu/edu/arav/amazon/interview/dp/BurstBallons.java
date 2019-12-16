package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/burst-balloons/
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] input = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            input[i + 1] = nums[i];
        }
        input[0] = 1;
        input[input.length - 1] = 0;
        int[][] dp = new int[input.length][input.length];
        for (int left = input.length - 3; left >= 0; left--) {
            for (int right = left + 2; right < input.length; right++) {
                for (int idx = left + 1; idx < right; idx++) {
                    dp[left][right] = Math.max(dp[left][right], input[left] * input[idx] * input[right] + dp[left][idx]
                            + dp[idx][right]);
                }
            }
        }

        return dp[0][input.length - 1];
    }
}
