package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    /**
     * @algo - arrayString
     * @time-complexity - O(nm) where n and m  - no. digits num1 and num2 respectively
     * @space-complexity - O(n+m)
     */

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] pro = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                pro[i + j + 1] += digit1 * digit2;
            }
        }

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = pro.length - 1; i >= 0; i--) {
            int digit = (carry + pro[i]) % 10;
            carry = (carry + pro[i]) / 10;
            ans.insert(0, String.valueOf(digit));
        }
        while(ans.length() != 0 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        return ans.toString();
    }
}
