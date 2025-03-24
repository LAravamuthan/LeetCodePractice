package asu.edu.marisol;


/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Searcha2DMatrix {

    /**
     * Using the row is in increasing order and rows are stacked one after other.
     *
     * @time-complexity - O (n * (n + 1) /2) ~ O(n^2) .
     * @space-complexity - O (n) , size of any row in the triangle -> if you want to achieve
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int pivotIdx = (right - left)/2 + left;
            int pivotElement = matrix[pivotIdx /n ][pivotIdx % n];

            if (pivotElement == target) return true;

            if (pivotElement < target) left = pivotIdx + 1;
            else right = pivotIdx - 1;
        }

        return false;
    }


}
