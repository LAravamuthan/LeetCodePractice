package asu.edu.arav.amazon.interview.medium;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (low - high) / 2;
            int ele = matrix[mid / m][mid % m];
            if (target == ele) {
                return true;
            } else if (target < ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
