package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    /* Time and Space complexity O(n^2) */
    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        /* this 2d array is the one will store the length of the longest
         * palindromic subsequence between indexes i.e dp[i][j] = longest palindromic
         * subsequence between index i and j of the string with i and j inclusive
         * */
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            /* the character individually are palindrome in itself
            hence the diagonal elements will values 1 */
            dp[i][i] = 1;
        }

        /* The approach is simple we start with difference between i and j being 1
         * and slowly increase the deference to be maximum possible i.e (n - 1) */

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; i + j < s.length(); j++) {
                /* if the two characters in question are equal
                 *  then already we have 2 + dp[j+1][j+i-1] i.e
                 *  longest palindromic subsequence of substring excluding
                 *  jth and (j + i)th positions*/
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] += 2 + dp[j + 1][j + i - 1];
                    /*
                     * Remember if i == 1 then dp[j + 1][j + i - 1] will be equal to 0
                     * as dp[3][2] doesnt make sense in the current context and default value
                     * is 0 hence it bodes well in our solution*/
                } else {
                    /* if the characters at jth and (j+i)th position are not equal,
                    then we have two either to exclude jth index and use the result of j+1
                     j + i or exclude (j + i) th and use the result of j and j + i - 1,
                     we choose the one which gives the maximum*/
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
