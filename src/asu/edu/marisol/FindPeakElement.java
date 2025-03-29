package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindPeakElement {

    /**
     * Standard linear search approach, O(n) approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) return i;
        }
        return nums.length - 1;
    }


    /**
     * Binary Search Approach, recursive.
     *
     * @time-complexity - O (log n).
     * @space-complexity - O (n) for recursion stack
     */
    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) return i;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int l, int r) {
        if (r == l) return l;

        int mid = (r - l) / 2 + l;
        if (mid + 1 < nums.length && nums[mid] < nums[mid + 1])
            return findPeakElement(nums, mid + 1, r);
        else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
            return findPeakElement(nums, l, mid - 1);
        return mid;
    }

    private int findPeakElement2(int[] nums, int l, int r) {
        if (r == l) return l;

        int mid = (r - l) / 2 + l;
        if (nums[mid] > nums[mid + 1])
            return findPeakElement(nums, l, mid);
        else
            return findPeakElement(nums, mid + 1, r);
    }

    /**
     * Binary Search Approach, iterative approach.
     *
     * @time-complexity - O (log n).
     * @space-complexity - O (1).
     */
    // TODO: This is one binary search variation when it comes to using while loop.
    public int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l)/2 + l;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }


}
