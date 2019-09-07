package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int sameColorCount = 0;
        int differentColorCount = k;
        int totalWays = sameColorCount + differentColorCount;

        for (int i = 1; i < n; i++) {
            sameColorCount = differentColorCount;
            differentColorCount = totalWays * (k - 1);
            totalWays = differentColorCount + sameColorCount;
        }
        return totalWays;
    }
}
