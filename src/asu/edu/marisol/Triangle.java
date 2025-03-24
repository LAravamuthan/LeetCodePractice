package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Triangle {

    /**
     * DP two dimensional if it need be, but top-down approach. No In-place updates but auxillary O(n) space.
     *
     * @time-complexity - O (n * (n + 1) /2) ~ O(n^2) .
     * @space-complexity - O (n) , size of any row in the triangle -> if you want to achieve
     */
    // TODO: counterIntuitive recursive method learn it.
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null && triangle.size() == 0) return 0;
        List<Integer> preRow = triangle.get(0);
        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> curRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int minFromPrevRow = Integer.MAX_VALUE;
                if (col > 0) minFromPrevRow = preRow.get(col - 1);
                if (col < row) minFromPrevRow = Math.min(minFromPrevRow, preRow.get(col));
                curRow.add(minFromPrevRow + triangle.get(row).get(col));
            }
            preRow = curRow;
        }
        return Collections.min(preRow);
    }


    /**
     * DP two-dimensional if it need be, but top-down approach. No In-place updates but auxiliary O(n) space.
     *
     * @time-complexity - O (n * (n + 1) /2) ~ O(n^2) .
     * @space-complexity - O (n) , size of any row in the triangle -> if you want to achieve
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null && triangle.size() == 0) return 0;
        int n = triangle.size();
        List<Integer> preRow = triangle.get(n - 1);
        for (int row = n - 2; row >= 0; row--) {
            List<Integer> curRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int minFromPrevRow = Math.min(preRow.get(col), preRow.get(col + 1));
                curRow.add(minFromPrevRow + triangle.get(row).get(col));
            }
            preRow = curRow;
        }
        return Collections.min(preRow);
    }
}
