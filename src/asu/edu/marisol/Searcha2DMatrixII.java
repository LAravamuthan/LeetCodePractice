package asu.edu.marisol;

public class Searcha2DMatrixII {

    /**
     * Divide and Conquer approach lets see.
     *
     * @time-complexity - O (nlogn).
     * @space-complexity - O (logn).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        return searchRec(0, n - 1, 0, m - 1, target, matrix);
    }

    private boolean searchRec(int left, int right, int up, int down, int target, int[][] matrix) {
        if (left > right || up > down) return false;

        if (target < matrix[up][left] || target > matrix[down][right]) return false;

        int row = up, mid = left + (right - left)/2;

        while (row <= down && matrix[row][mid] <= target) {
            if (target == matrix[row][mid]) return true;
            row++;
        }

        return searchRec(left, mid - 1, row, down, target, matrix) ||
                searchRec(mid + 1, right, up, row - 1, target, matrix);
    }


    /**
     * Space reduction approach.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (1).
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        int row = m - 1, col = 0;

        while (row >= 0 && col < n) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) row--;
            else col++;
        }

        return false;
    }

}
