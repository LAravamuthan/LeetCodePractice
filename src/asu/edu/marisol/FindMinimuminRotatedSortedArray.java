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


    /**
     * Binary Search approach, just by using pivot finding
     *
     * @time-complexity - O (log N).
     * @space-complexity - O (1).
     */
    public int findMin2(int[] nums) {

        int n = nums.length, left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return nums[left];
    }


    /**
     * Binary Search approach, Practise.
     *
     * @time-complexity - O (log N).
     * @space-complexity - O (1).
     */
    public int findMin3(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid + 1 < n && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[mid] <= nums[right])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return nums[left];
    }
}
