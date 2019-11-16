package asu.edu.arav.amazon.interview.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {

        int maxIdx = -1;
        int max = Integer.MIN_VALUE, sMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                sMax = max; // if any number is bigger than max then second Max
                // gets updated too
                max = n;
                maxIdx = i;
            } else if (n > sMax) { // if a number is bigger only than second Max
                // update only that, make sure this is else if
                // or else n will be  updated to  both max and Smax
                sMax = n;
            }
        }

        return max >= 2 * sMax ? maxIdx : -1;
    }
}
