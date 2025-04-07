package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FactorialTrailingZeroes {
    /**
     * The amount of 10 is equal to 2 and 5 pair as factors, in which 5 will drive the numbers of zeros.
     * No.of zeros in fact! for a number no number of 5 factors till n is n/5, lets say we want zero's for 25!.
     * 5 in 25 are 5, but the point to understand is the fact that 25 contributes one more extra 25.
     *
     * @time-complexity - O (log5n).
     * @space-complexity - O (1).
     */
    public int trailingZeroes(int n) {
        int zeros = 0;
        while (n > 0) {
            zeros += n/5;
            n /= 5;
        }
        return zeros;
    }

}
