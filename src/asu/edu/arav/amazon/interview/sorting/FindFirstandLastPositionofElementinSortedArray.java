package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        result = searchRange(nums, 0, nums.length - 1, target);
        return result;
    }


    public int[] searchRange(int[] nums, int low, int high, int target) {
        int[] result = new int[]{-1, -1};
        if (low > high) {
            return result;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int[] lowerResults = searchRange(nums, low, mid - 1, target);
                int[] higherResults = searchRange(nums, mid + 1, high, target);
                int lowerMin = lowerResults[0] == -1 ? Integer.MAX_VALUE : lowerResults[0];
                int higherMax = higherResults[1] == -1 ? Integer.MIN_VALUE : higherResults[1];
                result[0] = Math.min(lowerMin, mid);
                result[1] = Math.max(higherMax, mid);
                return result;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

}
