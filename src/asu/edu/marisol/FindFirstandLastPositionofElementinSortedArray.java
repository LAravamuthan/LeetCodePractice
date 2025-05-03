package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindFirstandLastPositionofElementinSortedArray {

    /**
     * Binary Search approach.
     *
     * @time-complexity - O (2logn).
     * @space-complexity - O (1).
     */
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = findBound(nums, target, true);
        if (firstOccurence == -1) return new int[] {-1, -1 };
        int secondOccurence = findBound(nums, target, false);
        return new int[] {firstOccurence, secondOccurence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Binary Search approach practice.
     *
     * @time-complexity - O (2logn).
     * @space-complexity - O (1).
     */
    public int[] searchRange2(int[] nums, int target) {
        int firstIdx = searchTarget(nums, target, true);
        if (firstIdx == -1) return new int[] {-1, -1};
        int secondIdx = searchTarget(nums, target, false);
        return new int[] {firstIdx, secondIdx};
    }

    private int searchTarget(int[] nums, int target, boolean firstPosition) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                if (firstPosition) {
                    if (mid == 0 || nums[mid - 1] != target) return mid;
                    else right = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                    else left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
