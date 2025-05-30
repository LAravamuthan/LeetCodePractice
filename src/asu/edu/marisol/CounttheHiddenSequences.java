package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CounttheHiddenSequences {

    /**
     * Iterate the difference array reconstruct each element, does not matter what you choose as the initial value.
     * While we recreate, keep note of largest and smallest element the difference between defines the wiggle
     * room we have for variation.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int max = 0, min = 0, cur = 0;

        for (int diff : differences) {
            cur += diff;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            if (max - min > upper - lower) return 0;
        }

        return (upper - lower) - (max - min) + 1;
    }

}
