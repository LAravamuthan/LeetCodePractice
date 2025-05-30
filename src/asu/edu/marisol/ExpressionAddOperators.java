package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ExpressionAddOperators {

    /**
     * Recursion approach.
     *
     * @time-complexity - O(4^N).
     * @space-complexity - O(N).
     */
    public List<String> addOperators(String num, int target) {

        this.num = num;
        this.target = target;
        this.answer = new ArrayList<>();
        this.ops = new ArrayList<>();

        recursion(0, 0, 0, 0);

        return answer;
    }

    private String num;
    private int target;
    private List<String> answer;
    private List<String> ops;

    private void recursion(int index, long value, long previousOperand, long currentOperand) {
        if (this.num.length() == index) {
            if (this.target == value && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                this.ops.subList(1, ops.size()).forEach(sb::append);
                answer.add(sb.toString());
            }
            return;
        }

        currentOperand = currentOperand * 10 + Character.getNumericValue(this.num.charAt(index));
        String currentValue = Long.toString(currentOperand);

        if (currentOperand > 0)
            recursion(index + 1, value, previousOperand, currentOperand); // No operation.

        // '+' operation.
        ops.add("+");
        ops.add(currentValue);
        recursion(index + 1, value + currentOperand, currentOperand, 0);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {

            // '-' operation.
            ops.add("-");
            ops.add(currentValue);
            recursion(index + 1, value - currentOperand, -currentOperand, 0);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // '*' operation.
            ops.add("*");
            ops.add(currentValue);
            recursion(index + 1, value - previousOperand + (currentOperand * previousOperand), currentOperand * previousOperand, 0);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

        }

    }

    /**
     * Recursion approach. practice.
     *
     * @time-complexity - O(4^N).
     * @space-complexity - O(N).
     */
    public List<String> addOperators2(String num, int target) {
        this.num = num;
        this.target = target;
        this.ops = new ArrayList<>();
        this.answer = new ArrayList<>();

        recur(0, 0, 0, 0);

        return answer;
    }

    private void recur(int index, long value, long previous, long currentOperand) {
        if (num.length() == index) {
            if (value == target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                // first element will always be a symbol specifically '+' to make sure currentOperand is zero.
                ops.subList(1, ops.size()).stream().forEach(sb::append);
                answer.add(sb.toString());
            }
            return;
        }

        currentOperand = currentOperand * 10 + num.charAt(index) - '0';
        if (currentOperand > 0) // escaping the leading zero here.
            recur(index + 1, value, previous, currentOperand); // no operation just make a bigger number

        ops.add("+");
        ops.add(String.valueOf(currentOperand));
        recur(index + 1, value + currentOperand, currentOperand, 0);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        // '-' & '*' can never be the first operation, because we are forming answer in this format "+1+2+3".
        if (ops.size() > 0) {
            ops.add("-");
            ops.add(String.valueOf(currentOperand));
            recur(index + 1, value - currentOperand, -currentOperand, 0);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            ops.add("*");
            ops.add(String.valueOf(currentOperand));
            recur(index + 1, value - previous + (currentOperand * previous), currentOperand * previous, 0);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

}
