package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinFallPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int[] pathSums = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            pathSums[i] = A[0][i];
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempPathSum = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                if (j == 0) {
                    tempPathSum[j] = Math.min(pathSums[j + 1], pathSums[j]) + A[i][j];
                    continue;
                }
                if (j == A[i].length - 1) {
                    tempPathSum[j] = Math.min(pathSums[j - 1], pathSums[j]) + A[i][j];
                    continue;
                }
                tempPathSum[j] = Math.min(pathSums[j + 1], Math.min(pathSums[j - 1], pathSums[j])) + A[i][j];
            }
            pathSums = tempPathSum;

        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < pathSums.length; i++) {
            if(pathSums[i] < result){
                result = pathSums[i];
            }
        }
        return result;
    }
}
