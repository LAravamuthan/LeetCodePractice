package asu.edu.aravl.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                answer[k] = nums1[i];
                i++;
                k++;
            } else {
                answer[k] = nums2[j];
                j++;
                k++;
            }
        }
        if (i < m) {
            while (i < m) {
                answer[k] = nums1[i];
                i++;
                k++;
            }
        }

        if (j < n) {
            while (j < n) {
                answer[k] = nums2[j];
                j++;
                k++;
            }
        }
        System.arraycopy(answer, 0, nums1, 0, m+n);
    }
}
