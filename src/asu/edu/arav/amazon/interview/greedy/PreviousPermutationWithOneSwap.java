package asu.edu.arav.amazon.interview.greedy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/previous-permutation-with-one-swap/
 */
public class PreviousPermutationWithOneSwap {

    /**
     * @algo - Greedy supposedly
     * @time-complexity - O(N)
     * @space-complexity - O(1)
     */

    public int[] prevPermOpt1(int[] A) {
        if (A == null && A.length < 2) return A;

        int i = A.length - 1;
        for (; i >= 1; i--) {
            if (A[i] < A[i - 1]) break;
        }
        int lessMaxIndx = -1;
        if (i > 0) {

            for (int j = i; j < A.length; j++) {
                if (A[j] < A[i - 1]) {
                    lessMaxIndx = lessMaxIndx == -1 ? j : (A[j] > A[lessMaxIndx] ? j : lessMaxIndx);
                }
            }
        }

        int tmp = A[lessMaxIndx];
        A[lessMaxIndx] = A[i - 1];
        A[i - 1] = tmp;
        return A;
    }
}
