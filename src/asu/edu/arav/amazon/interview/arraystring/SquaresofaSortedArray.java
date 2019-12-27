package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int i = 0; // last idx of the negative numbers
        int j = 0; // index from where the positive elements

        for (int element : A) {
            if (element < 0) {
                j++;
            } else {
                break;
            }
        }
        i = j - 1;
        int k = 0;// current idx of the resultant squared Array
        int res[] = new int[A.length];
        while (i >= 0 && j < A.length) { // until both negative and positive elements are not processed yet
            if (A[i] * A[i] < A[j] * A[j]) {
                res[k++] = A[i] * A[i];
                i--;
            } else {
                res[k++] = A[j] * A[j];
                j++;
            }
        }
        // if the negatives are the only  ones left
        while (i >= 0) {
            res[k++] = A[i] * A[i];
            i--;
        }
        // if the positives are the only  ones left
        while (j < A.length) {
            res[k++] = A[j] * A[j];
            j++;
        }
        return res;
    }

}

