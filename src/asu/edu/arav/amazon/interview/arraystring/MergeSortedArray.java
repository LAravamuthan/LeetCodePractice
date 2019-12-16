package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int ptrMain = m + n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            nums1[ptrMain--] = nums1[ptr1] < nums2[ptr2] ? nums2[ptr2--] : nums1[ptr1--];
        }
        // adding if missing elements from nums1
        System.arraycopy(nums2, 0, nums1, 0, ptr2 + 1);
    }
}
