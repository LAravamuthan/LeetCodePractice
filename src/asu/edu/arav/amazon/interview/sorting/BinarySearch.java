package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // this solution is with right as not inclusive boundary
    public int search2(int[] nums, int target) {
        int pivot, left = 0, right = nums.length;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot;
            else left = pivot + 1;
        }
        return -1;
    }
}
