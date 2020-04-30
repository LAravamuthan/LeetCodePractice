package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
 */
public class LeftmostColumnwithatLeastaOne {

    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions = new ArrayList<>();
    }

    /**
     *
     * @algo - Smart searchSpace reduction
     * @time-complexity - O(N+M), N - rows and M - cols
     * @space-complexity - O(1)
     */

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions.get(0);
        int cols = binaryMatrix.dimensions.get(1);
        int col = cols - 1;
        int row = 0;
        int minCol = cols;
        while (col >= 0 && row < rows) {
            if (binaryMatrix.get(row, col) == 1) {
                minCol = col;
                col--;
            } else {
                row++;
            }
        }
        return minCol == cols ? -1 : minCol;
    }
}
