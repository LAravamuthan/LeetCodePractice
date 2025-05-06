package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PalindromeNumber {

    /**
     * Smartest way, start from front and back and match.
     *
     * @time-complexity - O (n/2 ~ n).
     * @space-complexity - O (1).
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        return x == reverse || reverse /10 == x;
    }


    /**
     * Smartest way, start from front and back and match, practise.
     *
     * @time-complexity - O (n/2 ~ n).
     * @space-complexity - O (1).
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }

        return x == reverse || reverse / 10 == x;
    }

}
