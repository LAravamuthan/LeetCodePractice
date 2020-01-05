package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {

        if (nums == null || nums.length == 0 || m == 0) {
            return 0;
        }

        /*Here the dp states are stored as 2D array where dpSum[i][j]
         * meaning min max sum of j partitions in nums interval [0,i]*/
        int[][] dpSum = new int[nums.length + 1][m + 1];

        /* leftSum is the sum till index i taken from left */
        int[] leftSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                dpSum[i][j] = Integer.MAX_VALUE;
            }
        }
        dpSum[0][0] = 0;

        /*For every i and j pair, we have to see minimum by finding
         * for k from 0 till i  with j - 1 splits what was the min and choose the
         * the one which makes the min combination for k with j-1 splits and
         * sum of the rest of the elements */

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dpSum[i][j] = Math.min(dpSum[i][j], Math.max(dpSum[k][j - 1], leftSum[i] - leftSum[k]));
                }
            }
        }

        return dpSum[nums.length][m];
    }
}
