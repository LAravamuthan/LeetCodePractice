package asu.edu.arav.amazon.interview.stack;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLenght = 0;
        Stack<Integer> st = new Stack<Integer>();
        /* here we adding -1 to mark the the fact the values after -1 are forward brackets
         * first time a unmatched backward bracket comes in -1 is popped to make it the current
         * unmatched ) is used else where at any point in time it will store the last unmatched
         * backward bracket*/
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                /* if the charcter is not forward bracket
                 * match it with last forward if its not available we get a empty stack
                 *  and length of current index will be zero */
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                }
                maxLenght = Math.max(maxLenght, i - st.peek());
            }
        }
        return maxLenght;
    }
}
