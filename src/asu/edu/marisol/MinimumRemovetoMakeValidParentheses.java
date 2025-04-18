package asu.edu.marisol;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumRemovetoMakeValidParentheses {

    /**
     * Stack implementation for balancing.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n).
     */
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> st = new Stack<>();

        Set<Integer> indexToDelete = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) indexToDelete.add(i);
                else st.pop();
            }
        }

        while (!st.isEmpty()) indexToDelete.add(st.pop());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (indexToDelete.contains(i)) continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }


    /**
     * Balancing the brackets using counters itself.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n).
     */
    public String minRemoveToMakeValid2(String s) {

        int balance = 0;
        int open = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                balance++;
                open++;
            } else if (ch == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(ch);
        }

        StringBuilder result = new StringBuilder();
        int openToKeep = open - balance;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                if (openToKeep == 0) continue;
                openToKeep--;
            }
            result.append(sb.charAt(i));
        }

        return result.toString();
    }

}
