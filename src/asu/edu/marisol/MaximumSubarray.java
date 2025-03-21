package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumSubarray {

    /**
     * Efficient DP IMO, which constant time extra time and line time complexity.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int curProfit = nums[0];
        int maxProfit = nums[0];
        for (int i = 1; i < nums.length; i++)  {
            curProfit = Math.max(nums[i], curProfit + nums[i]);
            maxProfit = Math.max(maxProfit, curProfit);
        }
        return maxProfit;
    }

}
