package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        double i = 0;
        double base = 26.0;
        int l = s.length() - 1;
        double ans = 0;
        while (l >= 0) {
            double figure = s.charAt(l) - 'A' + 1;
            figure = Math.pow(base, i) * figure;
            ans += figure;
            l--;
            i++;
        }
        return (int) ans;
    }
}
