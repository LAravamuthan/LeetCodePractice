package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PlusOne {

    /**
     * Simple math maan.
     *
     * @time-complexity - O(n) obvious.
     * @space-complexity - O(n + 1 ~ n), worst case when all the elements are 9, we make a new array altogether.
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else {
                // this essentially means we at a point where a particular significant is not 9 so we can stop here
                // after increment.
                digits[i]++;
                return digits;
            }
        }

        // if we are here that means all of the numbers were 9(s), we need to add a new element to the digits at the front.
        // Smart way to do this, initialise a new array of digits (assuming initial value will be 0) with size n + 1,
        // and make the first idx value to be 0.

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
