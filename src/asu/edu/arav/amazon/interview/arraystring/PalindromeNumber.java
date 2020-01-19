package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    /**
     * @algo - Arrays
     * @time-complexity - O(n) n - number of digits
     * @space-complexity - O(1)
     */


    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + (x % 10);
            x /= 10;
        }
        return x == reversedNumber || reversedNumber / 10 == x;
    }
}
