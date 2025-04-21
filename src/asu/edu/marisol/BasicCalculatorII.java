package asu.edu.marisol;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BasicCalculatorII {

    /**
     * Stack usage for calculation.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int calculate(String s) {
        int result = 0, operand = 0;
        char operator = '+';
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = operand * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == n - 1) {
                if (operator == '+') {
                    st.push(operand);
                } else if (operator == '-') {
                    st.push(-operand);
                } else if (operator == '*') {
                    st.push(st.pop() * operand);
                } else if (operator == '/') {
                    st.push(st.pop() / operand);
                }
                operand = 0;
                operator = ch;
            }
        }

        while (!st.isEmpty()) result += st.pop();

        return result;
    }

    /**
     * Stack usage not done for calculation.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int calculate2(String s) {

        int result = 0, lastNumber = 0, curNumber = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                curNumber = curNumber * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {

                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = curNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = - curNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * curNumber;;
                } else if (operation == '/') {
                    lastNumber = lastNumber / curNumber;;
                }
                operation = ch;
                curNumber = 0;
            }
        }

        return result + lastNumber;
    }


}
