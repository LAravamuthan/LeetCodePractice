package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {


    /**
     * @algo - string
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        List<StringBuilder> ansList = new ArrayList<>();
        int curRow = 0;
        boolean down = false;
        for (char ch : s.toCharArray()) {
            if (ansList.size() == curRow) {
                ansList.add(new StringBuilder());
            }
            ansList.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb : ansList){
            ans.append(sb);
        }
        return ans.toString();
    }
}
