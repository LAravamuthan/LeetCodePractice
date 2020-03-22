package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {


    /**
     * @algo - String manipulation
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = 0; k < (j + 1 - i) / 2; k++) {
            if (s.charAt(i + k) != s.charAt(j - k)) return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return true;

        int l = s.length();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                return isPalindromeRange(s, i, l - i - 2) || isPalindromeRange(s, i + 1, l - i - 1);
            }
        }
        return true;
    }


    /**
     * @algo - String manipulation -- fucking concise
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */


    public boolean isPalindromeRange1(String s, int l, int r) {
        while (++l < r--) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }

    public boolean validPalindromeConsice(String s) {
        int l = -1;
        int r = s.length();
        while (++l < r--) {
            if (s.charAt(l) != s.charAt(r)) return isPalindromeRange1(s, l, r + 1) ||
                    isPalindromeRange1(s, l + 1, r);
        }
        return true;
    }
}
