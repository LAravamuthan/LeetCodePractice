package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class MinimumASCIIDeleteSumforTwoStrings {

    /**
     * @algo - Dynamic Programming
     * @time-complexity - O(N*M)
     * @space-complexity - O(N*M)
     */

    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] + s1.codePointAt(i - 1);
        for (int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i - 1] + s2.codePointAt(i - 1);

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.codePointAt(i - 1),
                            dp[i][j - 1] + s2.codePointAt(j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumforTwoStrings mst = new MinimumASCIIDeleteSumforTwoStrings();
        mst.minimumDeleteSum("sea", "eat");
    }
}
