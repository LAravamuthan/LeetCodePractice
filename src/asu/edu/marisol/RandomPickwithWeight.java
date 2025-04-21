package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RandomPickwithWeight {

    /**
     * Storing the prefixSum, and the total Sum.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public RandomPickwithWeight(int[] w) {
        this.prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++)
            prefixSum[i] = prefixSum[i - 1] + w[i];
        this.totalSum = prefixSum[w.length - 1];
    }

    private int[] prefixSum;
    private int totalSum;

    /**
     * picking from range using linear scan.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        for (; i < prefixSum.length; i++) {
            if (target < prefixSum[i]) break;
        }
        return i - 1;
    }

    /**
     * Picking from range using binary scan.
     *
     * @time-complexity - O (logn).
     * @space-complexity - O (1).
     */
    public int pickIndex2() {
        double target = this.totalSum * Math.random();

        int left = 0;
        int right = this.prefixSum.length;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (target > this.prefixSum[mid]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

}
