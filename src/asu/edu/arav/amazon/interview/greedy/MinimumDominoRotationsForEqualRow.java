package asu.edu.arav.amazon.interview.greedy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotationsForEqualRow {

    /**
     * @algo Greedy dont know how
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int minRotatation = Integer.MAX_VALUE;
        int[] possible = new int[]{A[0], B[0]};
        dominoFace:
        for (int i = 0; i < possible.length; i++) {
            int Arot = 0;
            int Brot = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == possible[i] && B[j] == possible[i]) {
                    continue;
                } else if (B[j] == possible[i]) {
                    Arot++;
                } else if (A[j] == possible[i]) {
                    Brot++;
                } else {
                    continue dominoFace;
                }
            }
            minRotatation = Math.min(minRotatation, Math.min(Arot, Brot));
        }
        return minRotatation == Integer.MAX_VALUE ? -1 : minRotatation;
    }

    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow mi = new MinimumDominoRotationsForEqualRow();
        mi.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
    }
}
