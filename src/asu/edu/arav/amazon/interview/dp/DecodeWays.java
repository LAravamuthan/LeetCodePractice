package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    // T - O(n) and S - O(n) dp algorithm
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int dp[] = new int[s.length()];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            int onlySelf = Integer.parseInt(s.substring(i, i + 1));
            int selfPrevious = Integer.parseInt(s.substring(i - 1, i + 1));
            // the character itself can be a number that can be decoded then it adds on to the
            // ways till previous
            if (onlySelf >= 1 && onlySelf <= 9) {
                dp[i] += dp[i - 1];
            }

            // similarily we check whether the previous element and current idx
            // can be a valid option then add on to the ways two previous

            if (selfPrevious >= 10 && selfPrevious <= 26) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[s.length() - 1];
    }
}
