package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class StringtoInteger {

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int idx = 0;
        int ans = 0;
        int sign = 1;
        // remove the white space
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }

        // handle the sign if provided
        if (idx < str.length() && (str.charAt(idx) == '+' || str.charAt(idx) == '-')) {
            sign = str.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }

        // till we process the last element
        while (idx < str.length()) {
            int digit = str.charAt(idx) - '0'; // to get a value between [0,9]
            if (digit < 0 || digit > 9) {
                // not a valid digit
                break;
            }

            // now check the case for overflow
            // the current total is already bigger than MAX/ 10 then one more multiplication is not possible
            // or if its equal to MAX/10 then digit should not be greater the last digit in the MAX INT
            if (Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // ans to be based on the sign remmember
            }

            ans = ans * 10 + digit;
            idx++;
        }

        return ans * sign;
    }

}
