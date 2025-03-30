package asu.edu.marisol;


/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumSizeSubarraySum {

    /**
     * This is follow-up of sliding window approach, binary Search one with value to search not the number but length of
     * numbers.
     *
     * TODO: BS_thread.
     * TODO: Also watch for the fact when to use lo < hi.
     *
     * @time-complexity - O(nlogn).
     * @space-complexity - O(1).
     */
    public int minSubArrayLen(int target, int[] nums) {
        int lo = 1, hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasSumWithLength(nums, mid, target))
                hi = mid;
            else
                lo = mid + 1;
        }

        return hasSumWithLength(nums, lo, target) ? lo : 0;
    }

    private boolean hasSumWithLength(int[] nums, int length, int target) {
        int curSum = 0;
        int n = nums.length;
        int i = 0;
        for (; i < length; i++) {
            curSum += nums[i];
            if (curSum >= target) return true;
        }

        while (i < n) {
            curSum += nums[i];
            curSum -= nums[i - length];
            if (curSum >= target) return true;
            i++;
        }

        return false;
    }

    /**
     * Sliding window approach.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int res = nums.length + 1;
        int lo = 0;
        int curSum = 0;

        for (int hi = 0; hi < nums.length; hi++) {
            curSum += nums[hi];
            while (curSum >= target && lo <= hi){
                res = Math.min(res, hi - lo + 1);
                curSum -= nums[lo++];
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }

}
