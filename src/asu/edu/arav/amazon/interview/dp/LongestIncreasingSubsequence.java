package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    // O(n^2) I am going to do here using Dp
    // this problem for strictly increasing
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // the logic here is that for every element we have check with
        // all the previous ( here remember we are making sub sequence so we need not dp sorting
        // as order is something we want to maintain)
        // idxes from which it can make a new length
        // this algorithm should for the case whether to include the current element or not
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            // for this current index
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLength = Math.max(maxLength, dp[j] + 1);
                }
            }
            dp[i] = maxLength;
            globalMax = Math.max(globalMax, maxLength);
        }

        return globalMax;
    }

}
