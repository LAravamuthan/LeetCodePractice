package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidPalindromeII {


    /**
     * The validPalindrome method with a twist of inclusion.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (1)
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            }

            i++;j--;
        }

        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {

        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

}
