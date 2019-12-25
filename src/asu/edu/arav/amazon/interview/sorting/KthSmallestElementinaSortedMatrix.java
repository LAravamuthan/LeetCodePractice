package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k < 1) {
            return -1;
        }

        int dimension = matrix.length;

        int lo = matrix[0][0];
        int high = matrix[dimension - 1][dimension - 1];

        // here the resultant lo will always be one of the values in matrix
        // Think through always why

        while (lo <= high) {
            int mid = lo + (high - lo) / 2;
            int countOfSmallerOrEqual = 0;
            int j = dimension - 1;
            for (int i = 0; i < dimension; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                countOfSmallerOrEqual += j + 1;
            }

            if (countOfSmallerOrEqual < k) {
                lo = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lo;
    }

}
