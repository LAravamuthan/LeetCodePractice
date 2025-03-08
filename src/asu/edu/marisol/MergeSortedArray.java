package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergeSortedArray {

    /**
     * Merging from front of the array.
     *
     * @time-complexity - O (n + m)
     * @space-complexity - O (m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int [] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0, p2 = 0;

        for (int p = 0; p < m + n; p++) {
            if (p2 == n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }


    /**
     * Merging from back of the array, better space and time optimized.
     *
     * @time-complexity - O (n + m)
     * @space-complexity - O (1)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int p1 = m - 1, p2 = n - 1;

        for (int p = n + m - 1; p >= 0; p--) {
            if (p2 < 0) break;
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
