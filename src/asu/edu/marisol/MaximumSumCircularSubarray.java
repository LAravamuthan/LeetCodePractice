package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumSumCircularSubarray {

    /**
     * Smartest way, kadane algo max and min application, start use of min subarray for max subarry in circular subarray.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], minSum = nums[0];
        int curMax = 0, curMin = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            curMin = Math.min(curMin + nums[i], nums[i]);
            maxSum = Math.max(curMax, maxSum);
            minSum = Math.min(curMin, minSum);
            totalSum += nums[i];
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }


    /**
     * Kadane algo two times and max of that.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int maxSubarraySumCircular2(int[] nums) {

        int totalSum = nums[0], maxSum = nums[0], curMaxSum = nums[0], minSum = nums[0], curMinSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            curMaxSum = Math.max(curMaxSum + nums[i], nums[i]);
            maxSum = Math.max(curMaxSum, maxSum);
            curMinSum = Math.min(curMinSum + nums[i], nums[i]);
            minSum = Math.min(minSum, curMinSum);
        }

        // Found for maxSum < 0, we don't want minSum give using minSum will lead to best sum of 0 meaning dont select
        // any num, that is not allowed.
        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }

}
