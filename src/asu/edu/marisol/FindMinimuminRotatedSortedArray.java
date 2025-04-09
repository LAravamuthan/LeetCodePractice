package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindMinimuminRotatedSortedArray {

    /**
     * Binary Search approach.
     *
     * @time-complexity - O (log N).
     * @space-complexity - O (1).
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}
