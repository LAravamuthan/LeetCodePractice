package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InterleavingString {

    /**
     * DP 2D classic problem.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (m * n).
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean [][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if (j == 0) dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    /**
     * DP 1D classic optimization.
     *
     * TODO: Learn this again.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (n).
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean [] dp = new boolean[s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) dp[j] = true;
                else if (i == 0) dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if (j == 0) dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else {
                    dp[j] = (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s2.length()];
    }

}
