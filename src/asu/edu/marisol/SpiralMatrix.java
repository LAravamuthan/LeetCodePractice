package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SpiralMatrix {

    /**
     * This is a simulation problem.
     * @time-complexity - O (n * m)
     * @space-complexity - O (n * m)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> ansList = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;

        int left = 0, right = cols - 1, up = 0, down = rows - 1;

        while (ansList.size() < rows * cols) {
            // moving from left to right keeping 'up' row constant
            for (int col = left; col <= right; col++) {
                ansList.add(matrix[up][col]);
            }

            // moving from up to down on the applicable right most, 'right' col constant
            for (int row = up + 1; row <= down; row++) {
                ansList.add(matrix[row][right]);
            }

            // non-traveresed row
            if (up < down) {
                // moving from right to left on the applicable bottom most row, 'down' col constant
                for (int col = right - 1; col >= left; col--) {
                    ansList.add(matrix[down][col]);
                }

            }

            // non-traveresed col
            if (left < right) {
                // moving from down to up on the applicable left most, 'left' col constant
                for (int row = down - 1; row > up; row--) {
                    ansList.add(matrix[row][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return ansList;
    }
}
