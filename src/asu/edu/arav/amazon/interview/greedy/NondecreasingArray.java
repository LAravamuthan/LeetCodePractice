package asu.edu.arav.amazon.interview.greedy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/non-decreasing-array/
 */
public class NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int cntOfInversion = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (cntOfInversion > 0) {
                    return false;
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }

                cntOfInversion++;

            }
        }
        return true;
    }

}
