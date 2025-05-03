package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaxConsecutiveOnesIII {


    /**
     * Sliding window approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int longestOnes(int[] nums, int k) {
        int maxLen = -1;
        int left = 0;
        int right = 0;
        int zeroCountInTheWindow = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCountInTheWindow++;
            }

            while (zeroCountInTheWindow > k) {
                if (nums[left] == 0) zeroCountInTheWindow--;
                left++;
            }

            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen;
    }

    /**
     * Sliding window approach, optimizied to never reduce the window, get the maximum size and keep rolling with it.
     * The idea is the window size must have been valid at least at some point.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int longestOnes2(int[] nums, int k) {

        int left = 0, right;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;

            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }

        // +1 required would have been taken care by the for loop overflow.
        return right - left;
    }

}
