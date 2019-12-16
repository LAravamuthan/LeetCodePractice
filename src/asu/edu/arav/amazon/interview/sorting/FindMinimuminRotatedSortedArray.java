package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        if(nums[r] > nums[l]){
            return nums[l];
        }
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[l]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[0];
    }
}
