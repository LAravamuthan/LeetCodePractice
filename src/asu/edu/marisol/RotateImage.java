package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RotateImage {

    /**
     * Rotate array, transpose and reflect (reverse by rows).
     *
     * @time-complexity - O (m), n * n where n is the row and n is col.
     * @space-complexity - O (1)
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    /**
     * Rotate array, cyclic conversion.
     *
     * @time-complexity - O (m), n * n where n is the row and n is col.
     * @space-complexity - O (1)
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1)/2; i++) {
            for(int j = 0; j < n/2; j++) {
                int tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
