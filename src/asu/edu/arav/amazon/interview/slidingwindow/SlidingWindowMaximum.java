package asu.edu.arav.amazon.interview.slidingwindow;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {


    // O(n) solution with O(n) space complexity
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        // first we form the left array
        // in which we are  iterating from left to right
        // at each index left[i] is going to be the max at that
        // index for the parition in many partition present of sjze k
        // in the same loop we form the right array
        // at right[j] is max at the index checked from the end
        // of partition of the size k
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                // Here this step will pop the max forward in the block
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - 1 - i;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                // Here too this will pop the max backward in the block
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] out = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            // i + 2 th left is pointing max till that index in that partition and
            // i th index is pointing max from that index to the end of partition its part of
            out[i] = Math.max(left[i + 2], right[i]);
        }
        return out;
    }

}
