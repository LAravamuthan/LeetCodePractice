package asu.edu.arav.amazon.interview.dp;

import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/triangle/
 */
public class Triangle {


    /**
     * @algo - DP
     * @time-complexity - O(n^2)
     * @space-complexity - O(n)
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int[] minPathSum = new int[triangle.size()];

        /* start from the bottom row each col dp value is the element value at j itself
           and for rows above check the adjacent dp values
           */
        /*
            we can get a solution with O(1) space complexity but we will modify the input triangle
         */
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == triangle.size() - 1) minPathSum[j] = triangle.get(i).get(j);
                else minPathSum[j] = Math.min(minPathSum[j], minPathSum[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minPathSum[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        /* start from the bottom row each col dp value is the element value at j itself
           and for rows above check the adjacent dp values
           */
        /*
            we can get a solution with O(1) space complexity but we will modify the input triangle
         */
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
                        + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

}
