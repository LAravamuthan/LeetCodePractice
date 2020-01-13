package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */

public class PartitionEqualSubsetSum {

    /**
     * @algo Dynamic Programming
     * @time-complexity - O(n^2)
     * @space-complexity - O(n^2)
     */

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        /* if the sum is not even then they cant be distributed into two equal parts */
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        /* then we make include or exclude each element for making the all sums from 1
         * to sum/2 */
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        /* now for making 0 sum is possible for all elements */
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        /* now for making any sum from no elements is not possible */
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                /* lets first not include current element */
                dp[i][j] = dp[i - 1][j];
                /* if the this is not possible lets check it can be included*/
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * @algo Dynamic Programming
     * @time-complexity - O(n^2)
     * @space-complexity - O(n)
     */

    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        /* if the sum is not even then they cant be distributed into two equal parts */
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        /* then we make include or exclude each element for making the all sums from 1
         * to sum/2 */
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;

        /* here only difference from previous implementation is the fact that we wont use one more
         * dimension for elements since we wanted i-1 elements state only for state i
         * the same can be formed for making sum from the max sum to 1 since
         * the lower sum can be made from the elements */

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                dp[i] = dp[i] || (i >= num && dp[i - num]);
            }
        }
        return dp[sum];
    }
}
