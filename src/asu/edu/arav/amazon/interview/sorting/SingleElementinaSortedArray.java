package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementinaSortedArray {

    /**
     *
     * @algo - tricky modified binary search
     * @time-complexity - O(logN)
     * @space-complexity - O(1)
     */

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean halvesEven = (high - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (halvesEven) low = mid + 2;
                else high = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if (halvesEven) high = mid - 2;
                else low = mid + 1;
            }else return nums[mid];
        }
        return nums[low];
    }
}
