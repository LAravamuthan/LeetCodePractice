package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidPalindromeIII {

    /**
     * The validPalindrome method with recursion, and good way to understand deletion.
     * Top-down approach.
     *
     * @time-complexity - O (n^2)
     * @space-complexity - O (n^2)
     */
    public boolean isValidPalindrome(String s, int k) {
        memo = new Integer[s.length()][s.length()];
        return deletionToMakePalindrome(0, s.length() - 1, s) <= k;
    }

    Integer [][] memo;

    private int deletionToMakePalindrome(int i, int j, String s) {
        // no deletion required for single character
        if (i == j) return 0;

        // two adjacent characters.
        if (i + 1 == j) return s.charAt(i) != s.charAt(j) ? 1 : 0;

        if (memo[i][j] != null) return memo[i][j];

        if (s.charAt(i) == s.charAt(j))
            memo[i][j] = deletionToMakePalindrome(i + 1, j - 1, s);
        else
            memo[i][j] = 1 + Math.min(deletionToMakePalindrome(i + 1, j, s), deletionToMakePalindrome(i, j - 1, s));

        return memo[i][j];
    }


    /**
     * The validPalindrome, 2D dp bottom-up approach
     *
     * @time-complexity - O (n^2)
     * @space-complexity - O (n^2)
     */
    public boolean isValidPalindrome2(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][s.length() - 1] <= k;
    }


    /**
     * The validPalindrome, 1D dp bottom-up approach
     *
     * @time-complexity - O (n^2)
     * @space-complexity - O (n^2)
     */
    public boolean isValidPalindrome3(String s, int k) {

        int [] dp = new int[s.length()];

        for (int i = s.length() - 2; i >= 0; i--) {
            // this will be representative of dp [i + 1][j - 1] since i is decreasing and j is increasing
            // Also for fresh i this will be zero since we start with j = i + 1 that is adjacent number.
            int prev = 0;
            for (int j = i + 1; j < s.length(); j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = prev;
                // dp[j] should be previous i, so dp[i + 1][j]
                // dp[j - 1] is already updated so it is dp[i][j - 1]
                else
                    dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
                // dp[i + 1][j - 1] for next j iteration.
                prev = temp;
            }
        }

        return dp[s.length() - 1] <= k;
    }


}
