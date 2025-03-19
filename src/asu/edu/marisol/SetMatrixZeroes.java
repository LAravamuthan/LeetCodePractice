package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SetMatrixZeroes {

    /**
     * Set rows and cols to zero based on initial setting of row and col heads.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (1)
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Store which r and c are to be used as reference for setting others as zero in the matrix.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M + N) --> rows plus cols
     */
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> zeroRows = new HashSet();
        Set<Integer> zeroCols = new HashSet();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
