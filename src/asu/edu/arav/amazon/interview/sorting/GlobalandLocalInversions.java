package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/global-and-local-inversions/
 */
public class GlobalandLocalInversions {
    /**
     * Algorithm - linear scan with some context
     * Time complexity - O(n)
     * Space complexity - O(1)
     */

    public boolean isIdealPermutation(int[] A) {

        /*All the global inversion are local hence if we even have one global inversion
         * the permutation wont be ideal */
        /*Here the idea is to keep the finding the minimum from bebind
         * then if a element[i - 2] is greater than the minimum till i from right
         * then we have one global inversion which is not local */

        int minFromRight = Integer.MAX_VALUE;
        for (int i = A.length; i >= 2; i--) {
            minFromRight = Math.min(minFromRight, A[i]);
            if (A[i - 2] > minFromRight) {
                return false;
            }
        }
        return true;
    }
}
