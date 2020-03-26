package asu.edu.arav.amazon.interview.stack;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {


    /**
     * @algo - stack using operations
     * @time-complexity - O(n) n - no. of characters
     * @space-complexity - O(n)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> resValues = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (!Character.isDigit(s.charAt(i)) && !(s.charAt(i) == ' ') || i == s.length() - 1) {
                if (sign == '+') resValues.push(num);
                if (sign == '-') resValues.push(-num);
                if (sign == '*') resValues.push(resValues.pop() * num);
                if (sign == '/') resValues.push(resValues.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        while (!resValues.isEmpty()){
            num += resValues.pop();
        }
        return num;
    }


    /**
     * @algo - stack using operations
     * @time-complexity - O(n) n - no. of characters
     * @space-complexity - O(1)
     */
    public int calculate1(String s) {
        if (s == null || s.length() == 0) return 0;
        char sign = '+';
        int num = 0;
        int sum = 0;
        int bufferSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (!Character.isDigit(s.charAt(i)) && !(s.charAt(i) == ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    sum+=bufferSum;
                    bufferSum = num;
                }
                if (sign == '-') {
                    sum+=bufferSum;
                    bufferSum = -num;
                }
                if (sign == '*') {
                    bufferSum*=num;
                }
                if (sign == '/') {
                    bufferSum/=num;
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        sum+=bufferSum;
        return sum;
    }
}
