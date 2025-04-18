package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IntegertoRoman {

    /**
     * Integer to Roman.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    private static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };



}
