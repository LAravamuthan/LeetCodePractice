package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/spiral-matrix/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */

public class SpiralMatrix {

    /**
     * @algo - arrays & String
     * @time-complexity - O(nm)
     * @space-complexity - O(1)
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int r1 = 0, r2 = matrix.length;
        int c1 = 0, c2 = matrix[0].length;
        while (r1 < r2 && c1 < c2) {
            /* Keeping top row constant moving from left to right */
            for (int c = c1; c < c2; c++) res.add(matrix[r1][c]);
            /* Keeping rightmost col constant moving from top to bottom */
            for (int r = r1 + 1; r < r2; r++) res.add(matrix[r][c2 - 1]);
            if (r1 < r2 - 1 && c1 < c2 - 1) { /*If the there is a row between r1 and r2 and same way for col*/
                /* Keeping bottom row constant moving from right to left */
                for (int c = c2 - 2; c > c1; c--) res.add(matrix[r2 - 1][c]);
                /* Keeping leftmost col constant moving from bottom to top */
                for (int r = r2 - 1; r > r1; r--) res.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
