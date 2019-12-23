package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(s).reverse().toString();
        return reverse.equals(s);
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        vp.isPalindrome("0P");
    }

}
