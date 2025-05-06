package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ToeplitzMatrix {

    /**
     * Going to each element, checking the diagonal element below if avaialble.
     *
     * @time-complexity - O(nlogn + n^2).
     * @space-complexity - O(n).
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row + 1 < rows && col + 1 < cols && matrix[row][col] != matrix[row + 1][col + 1])
                    return false;
            }
        }

        return true;
    }

}
