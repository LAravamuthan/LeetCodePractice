package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PalindromicSubstrings {

    /**
     * Expanding from middle approach.
     *
     * @time-complexity - O (N^2).
     * @space-complexity - O (1).
     */
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            // for odd sized palindromes
            ans += countPalindromes(s, i, i);

            // for even sized palindromes
            ans += countPalindromes(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromes(String s, int low, int high) {
        int count = 0;

        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) break;

            count++; low--; high++;
        }

        return count;
    }


    /**
     * Let me try the typical Dynamic programming approach for palindromes, 2-D array one.
     * In here whenever we find a samller sized palindrome, we increment the overall count.
     *
     * @time-complexity - O (N^2).
     * @space-complexity - O (1).
     */
    public int countSubstrings2(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // for single sized palindromes
        for (int i = 0; i < s.length(); i++, count++) dp[i][i] = true;

        // for double sized palindromes
        for (int i = 0; i + 1 < s.length(); i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            count += dp[i][i + 1] ? 1 : 0;
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                count += dp[i][j] ? 1 : 0;
            }
        }

        return count;
    }

}
