package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class MaximizeSumOfArrayAfterKNegations {

    /**
     *
     * @algo - ArraysString
     * @time-complexity - O(NlogN)
     * @space-complexity - O(1)
     */

    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int sum = 0;
        /* sort to making use of  negative one */
        Arrays.sort(A);
        int i = 0;
        int min = Integer.MAX_VALUE;
        /* add all the negative numbers by negating them till k ends or negative ends */

        for (; i < A.length && K > 0 && A[i] < 0; i++, K--) {
            sum += -A[i];
            min = Math.min(min, -A[i]);
        }
        /* always keep note minimum have to reduce that at the end */

        for (; i < A.length; i++) {
            sum += A[i];
            min = Math.min(min, A[i]);
        }
        return sum - (K % 2) * min * 2;
    }
}
