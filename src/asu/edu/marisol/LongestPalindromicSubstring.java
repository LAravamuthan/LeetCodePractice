package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestPalindromicSubstring {

    /**
     * Expanding from middle algorithm, nice for the the interview method.
     *
     * @time-complexity - O (n^2).
     * @space-complexity - O (1).
     */
    public String longestPalindrome(String s) {
        this.s = s;
        int [] ans = {0, 0};

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i);
            if (oddLength > ans[1] - ans[0] + 1) {
                int half = oddLength / 2;
                ans[0] = i - half;
                ans[1] = i + half;
            }
            int evenLength = expand(i, i + 1);
            if (evenLength > ans[1] - ans[0] + 1) {
                int half = evenLength / 2;
                ans[0] = i - half + 1;
                ans[1] = i + half;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private String s;

    private int expand(int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }


    /**
     * Super DP problem with 2D dp array, good candidate for interview too.
     *
     * @time-complexity - O (n^2).
     * @space-complexity - O (n^2).
     */
    public String longestPalindrome2(String s) {
        int[] ans = {0, 0};
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Initial condition for subString size of 1.
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // Initial condition for subString size of 2.
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        // for string size more than 2.
        for (int diff = 2; diff < s.length(); diff++) {
            for (int i = 0; i + diff < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i + diff) && dp[i + 1][i + diff - 1]) {
                    dp[i][i + diff] = true;
                    ans[0] = i;
                    ans[1] = i + diff;
                }
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }
}
