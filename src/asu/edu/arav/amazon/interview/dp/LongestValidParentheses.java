package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

        /* Dp algo with Time and Space Complexity - O(n) */
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int maxLength = 0;
            int[] dp = new int[s.length()];

            for (int i = 1; i < s.length(); i++) {
                /* only when we get a backward bracket we start find the matching forward */
                if (s.charAt(i) == ')') {
                    /* if the previous character is a forward bracket then we just to have add
                     *the to the max length substring till previous of previous*/
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        /*this condition is check if previous element is not a '('
                         *then we check if the character before the max valid substring
                         *formed by the previous((i-1) th) i.e character @ i - dp[i -1] -1 is '('
                         *if it is so then total length for current index i id substring length
                         * of previous length + substring length of index previous to
                         *matched forward bracket ( i - dp[i -1] -1) i.e dp[i - dp[i -1] -1 - 1]
                         *+ 2 */
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
            return maxLength;
        }
}
