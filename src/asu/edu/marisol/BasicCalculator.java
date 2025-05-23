package asu.edu.marisol;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BasicCalculator {

    /**
     * Stack usage for calculation.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int calculate(String s) {

        Stack<Object> st = new Stack<>();
        int operand = 0;
        int n = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand += (int) Math.pow(10, n) * (int) ch - '0';
                n++;
            } else if (ch != ' ') {
                if (n != 0) {
                    st.push(operand);
                    operand = 0;
                    n = 0;
                }
                if (ch == '(') {
                    int res = evaluateExpr(st);
                    st.pop();
                    st.push(res);

                } else {
                    st.push(ch);
                }
            }
        }
        if (n != 0) st.push(operand);

        return evaluateExpr(st);
    }

    private int evaluateExpr(Stack<Object> st) {

        if (st.isEmpty() || !(st.peek() instanceof Integer)) st.push(0);
        int res = (int) st.pop();
        while(!st.isEmpty() && (char) st.peek() != ')') {
            char sign = (char) st.pop();
            if (sign == '+') res += (int) st.pop();
            else res -= (int) st.pop();
        }

        return res;
    }


    /**
     * Stack usage for calculation but only for brackets
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int calculate2(String s) {
        int result = 0, operand = 0, sign = 1;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = 10 * operand + ch - '0';
            } else if (ch != ' ') {
                if (ch == '+') {
                    result += sign * operand;
                    operand = 0;
                    sign = 1;
                } else if (ch == '-') {
                    result += sign * operand;
                    operand = 0;
                    sign = - 1;
                } else if (ch == '(') {
                    st.push(result);
                    st.push(sign);

                    result = 0;
                    sign = 1;
                } else if (ch == ')') {
                    result += sign * operand;
                    result *= st.pop();
                    result += st.pop();

                    sign = 1;
                    operand = 0;
                }
            }
        }

        return result + (sign * operand);
    }

    /**
     * Stack usage for calculation but only for brackets practice.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int calculate3(String s) {
        int result = 0;
        int sign = 1;
        int operand = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = operand * 10 + ch - '0';
            } else if (ch != ' ') {
                if (ch == '+') {
                    result += sign * operand;
                    sign = 1;
                    operand = 0;
                } else if (ch == '-') {
                    result += sign * operand;
                    sign = -1;
                    operand = 0;
                } else if (ch == '(') {
                    st.push(result);
                    st.push(sign);

                    result = 0;
                    sign = 1;
                } else if (ch == ')') {
                    result += sign * operand;
                    result *= st.pop();
                    result += st.pop();

                    sign = 1;
                    operand = 0;
                }
            }
        }

        return result + (sign * operand);
    }

}
