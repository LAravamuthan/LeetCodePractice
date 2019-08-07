package asu.edu.Arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class LargestSumOfAverages {


    public double largestSumOfAverages(int[] A, int K) {
        double[] sumTillPreviousIndex = new double[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sumTillPreviousIndex[i + 1] = sumTillPreviousIndex[i] + A[i];
        }
        double[] averagesFromIndex = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            averagesFromIndex[i] = (sumTillPreviousIndex[A.length] - sumTillPreviousIndex[i]) / (A.length - i);
        }
        for (int i = 0; i < K - 1; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    averagesFromIndex[j] = Math.max(averagesFromIndex[j],
                            (sumTillPreviousIndex[k] - sumTillPreviousIndex[j]) / (k - j) + averagesFromIndex[k]);
                }
            }
        }
        return averagesFromIndex[0];
    }

}
