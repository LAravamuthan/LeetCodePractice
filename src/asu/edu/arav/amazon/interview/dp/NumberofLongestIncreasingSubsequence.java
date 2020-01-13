package asu.edu.arav.amazon.interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */

public class NumberofLongestIncreasingSubsequence {

    /**
     * @algo Dynamic Programming
     * @time-complexity - O(n^2)
     * @space-complexity - O(n)
     */

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] idxCount = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(idxCount, 1);

        int maxLen = 1;
        Map<Integer, Integer> lengthCount = new HashMap<Integer, Integer>();
        lengthCount.put(1, 1);
        for (int i = 1; i < nums.length; i++) {
            lengthCount.put(1, i+1);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int preLength = dp[i];
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) {
                        idxCount[i] = preLength == dp[i] ? idxCount[i] + idxCount[j] : idxCount[j];
                    }
                }
                if (dp[i] >= maxLen && dp[i] > 1) {
                    if (maxLen < dp[i]) {
                        maxLen = dp[i];
                    }
                    lengthCount.put(dp[i], lengthCount.getOrDefault(dp[i], 0) + idxCount[i]);
                }
            }
        }
        return lengthCount.get(maxLen);
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence nlis = new NumberofLongestIncreasingSubsequence();
        nlis.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }
}
