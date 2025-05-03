package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class DiagonalTraverse {

    /**
     * Simulation based solution.
     *
     * @time-complexity - O (N * M).
     * @space-complexity - O (1).
     */
    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        List<Integer> answer = new ArrayList<>();

        int i = 0, j = 0;
        answer.add(mat[i][j]);
        boolean down = true;

        while (answer.size() != rows * cols) {
            if (down) {
                if (j < cols - 1) j++;
                else i++;

                while (i < rows && j >= 0) {
                    answer.add(mat[i][j]);
                    i++; j--;
                }
                i--; j++;
                down = false;
            } else {
                if (i < rows - 1) i++;
                else j++;

                while (i >= 0 && j < cols) {
                    answer.add(mat[i][j]);
                    i--; j++;
                }
                i++; j--;
                down = true;
            }
        }

        int[] result = new int[answer.size()];

        for (int k = 0; k < answer.size(); k++) {
            result[k] = answer.get(k);
        }

        return result;
    }


    /**
     * Simulation based solution, with making things cleaner.
     *
     * @time-complexity - O (N * M).
     * @space-complexity - O (1).
     */
    public int[] findDiagonalOrder2(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];

        int row = 0, col = 0, idx = 0;
        boolean down = false;

        while (idx < rows * cols) {
            result[idx++] = mat[row][col];
            if (down) {
                if (row == rows - 1) {
                    col++;
                    down = false;
                } else if (col == 0) {
                    row++;
                    down = false;
                } else {
                    row++; col--;
                }
            } else {
                if (col == cols - 1) {
                    row++;
                    down = true;
                } else if (row == 0) {
                    col++;
                    down = true;
                } else {
                    row--; col++;
                }
            }
        }

        return result;
    }


    /**
     * Even faster approach.
     *
     * @time-complexity - O (N * M).
     * @space-complexity - O (1).
     */
    public int[] findDiagonalOrder3(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];

        up(mat, 0, 0,0, result);
        return result;
    }

    private void up(int[][] mat, int idx, int row, int col, int[] result) {
        if (idx == result.length) return;

        while (row >= 0 && col < mat[0].length) {
            result[idx++] = mat[row--][col++];
        }

        if (col < mat[0].length) down(mat, idx, row + 1, col, result); // going right
        else down(mat, idx, row + 2, col - 1, result); // going down

    }

    private void down(int[][] mat, int idx, int row, int col, int[] result) {
        if (idx == result.length) return;

        while (row < mat.length && col >= 0) {
            result[idx++] = mat[row++][col--];
        }

        if (row < mat.length) up(mat, idx, row, col + 1, result); // going down
        else up(mat, idx, row - 1, col + 2, result); // going right
    }

}
