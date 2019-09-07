package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NoOfArthimeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp++;
                sum += dp;
            } else {
                dp = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(in));
    }
}
