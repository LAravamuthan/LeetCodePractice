package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    /**
     * @algo - Two pointer sliding window
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sIdx = 0;
        int eIdx = 0;
        int res = Integer.MAX_VALUE;
        int cursum = 0;
        while (eIdx < nums.length) {
            cursum += nums[eIdx];
            while (cursum >= s && sIdx <= eIdx) {
                res = Math.min(eIdx - sIdx + 1, res);
                cursum -= nums[sIdx++];
            }
            eIdx++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
