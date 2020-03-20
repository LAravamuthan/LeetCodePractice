package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {

    /**
     *
     * @algo - dp
     * @time-complexity - O(n*m)
     * @space-complexity - O(n*m)
     */

    int[][] dpSum = null;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dpSum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                dpSum[i + 1][j + 1] = matrix[i][j] + dpSum[i + 1][j] + dpSum[i][j + 1] - dpSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dpSum[row2 + 1][col2 + 1] - dpSum[row2 + 1][col1] - dpSum[row1][col2 + 1] + dpSum[row1][col1];
    }
}
