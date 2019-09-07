package asu.edu.aravl.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        double runningSum = 0.0;
        double maxRunningSum = 0.0;
        for (int i = 0; i < k; i++) {
            runningSum += nums[i];
        }
        maxRunningSum = runningSum;

        for (int i = k; i < nums.length; i++) {
            runningSum = nums[i] - nums[i - k];
            maxRunningSum = Math.max(runningSum, maxRunningSum);
        }
        return maxRunningSum/k;
    }
}
