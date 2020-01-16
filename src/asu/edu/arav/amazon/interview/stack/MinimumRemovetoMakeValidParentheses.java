package asu.edu.arav.amazon.interview.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemovetoMakeValidParentheses {

    /**
     * @algo - stack usage
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */


    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> st = new Stack<Integer>();
        Set<Integer> toBePrePared = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty() || s.charAt(st.peek()) != '(') {
                    st.push(i);
                } else {
                    st.pop();
                }
            }
        }
        while (!st.isEmpty()) {
            toBePrePared.add(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toBePrePared.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
