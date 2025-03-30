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
        // TODO: understand more why condition for negative case, but for this makes sense
        //  for all negative element based array.
        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }

}
