package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class KnightDailer {
    public static int knightDialer(int N) {

        int[][] dailerDistinctNumbers = new int[4][3];
        int[][] dailerDistinctNumbersTemp = new int[4][3];

        if (dailerDistinctNumbers == null || dailerDistinctNumbers.length == 0) {
            return 1;
        }

        long totalDN = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < dailerDistinctNumbers.length; j++) {
                for (int k = 0; k < dailerDistinctNumbers[0].length; k++) {
                    if ((j != 3 || k != 0) && (j != 3 || k != 2)) {
                        if (i == 0) {
                            dailerDistinctNumbers[j][k] = 1;
                            continue;
                        }
                        if (j + 2 < 4 && k + 1 < 3) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j + 2][k + 1];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);

                        }
                        if (j + 2 < 4 && k - 1 > -1) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j + 2][k - 1];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);

                        }
                        if (j + 1 < 4 && k + 2 < 3) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j + 1][k + 2];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }
                        if (j + 1 < 4 && k - 2 > -1) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j + 1][k - 2];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }
                        if (j - 2 > -1 && k + 1 < 3) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j - 2][k + 1];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }
                        if (j - 2 > -1 && k - 1 > -1) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j - 2][k - 1];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }
                        if (j - 1 > -1 && k + 2 < 3) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j - 1][k + 2];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }
                        if (j - 1 > -1 && k - 2 > -1) {
                            dailerDistinctNumbers[j][k] += dailerDistinctNumbersTemp[j - 1][k - 2];
                            dailerDistinctNumbers[j][k] %= (Math.pow(10, 9) + 7);
                        }

                    }
                }
            }
            dailerDistinctNumbersTemp = dailerDistinctNumbers;
            dailerDistinctNumbers = new int[4][3];
        }

        for (int j = 0; j < dailerDistinctNumbers.length; j++) {
            for (int k = 0; k < dailerDistinctNumbers[0].length; k++) {
                totalDN += dailerDistinctNumbersTemp[j][k];
            }
        }

        return (int)(totalDN % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        System.out.println(knightDialer(4));
    }

    


}
